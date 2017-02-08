package automationFramework;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import pageObjectsActions.*;
import pageObjectsElements.*;
import utility.RandomNumber;
import utility.ReadXMLFile;
import utility.RetryRule;

import java.io.File;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Plot_TestCase extends TestCase {

    //driver initialize
    private static WebDriver driver = null;
    private static ChromeDriverService service = null;

    @BeforeClass
    public static void createAndStartService() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(ReadXMLFile.takeConstantFromXML("DriverPath", "ChromeDriver", "path")))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //stop service
    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    //create new driver
    @Before
    public void createNewDriver() {
        try {
            driver = new RemoteWebDriver(service.getUrl(),
                    DesiredCapabilities.chrome());
        } catch (UnreachableBrowserException e) {

            driver = new RemoteWebDriver(service.getUrl(),
                    DesiredCapabilities.chrome());

        }

        driver.get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));
    }

    //execute after each TC
    @After
    public void quitDriver() {
        driver.quit();
    }

    //Timeout Rule that applies to all test cases in the test class
    @Rule
    public Timeout globalTimeout = Timeout.seconds(300);


    //Rerun failed tests 3 times
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    //log in
    @Test
    public void logIn(){

        //click on Log in link
        HeaderActions.clickOnLogIn(driver);

        //fill all fields and click login button
        HomePageActions.logIn_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"), ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));

        //check username
        assertEquals(ReadXMLFile.takeConstantFromXML("Account", "Main", "userName"), HeaderElements.lnk_Profile(driver).getText());
    }

    //check forgot password flow
    @Test
    public void forgotPassword(){

        //click on Log in link
        HeaderActions.clickOnLogIn(driver);

        //go to Forgot password page
        HomePageActions.goToForgotPasswordPage(driver);

        //type email and click on Forgot password button
        ForgotPasswordPageActions.forgotPassword_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Forgot Password Confirm", "url"), driver.getCurrentUrl());
    }

    //sign up without review flow
    @Test
    public void signUpWithoutReview(){

        //click on Sign Up button in the Header
        HeaderActions.clickOnSignUp(driver);

        //Sign Up as aignatiuk@archer-soft.com with 'lytghjgtnhjdcr' password
        SignUpPageActions.SignUp_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));

        //verify that current URL is correct
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "SignUp Confirmation Page", "url"), driver.getCurrentUrl());

        //verify that current logged user has correct profile user name
        assertEquals(HeaderElements.lnk_Profile(driver).getText(), String.valueOf(RandomNumber.currentRandomNumber()));

        //Find Treatments button exists
        assertTrue(SignUpConfirmationPageElements.button_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed());

        // Write a Review button exists
        assertTrue(SignUpConfirmationPageElements.button_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed());
    }


}
