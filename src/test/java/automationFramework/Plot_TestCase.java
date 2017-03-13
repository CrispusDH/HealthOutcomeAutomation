package automationFramework;

import PageObject.ForgotPasswordConfirmationPage;
import PageObject.Header;
import PageObject.HomePage;
import PageObject.SignUpConfirmationPage;
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
import utility.ReadXMLFile;
import utility.RetryRule;

import java.io.File;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Plot_TestCase extends TestCase {

    //<editor-fold desc="Initialisation block">

    private WebDriver driver;
    private static ChromeDriverService service;

    private Header header;
    private ForgotPasswordConfirmationPage forgotPasswordConfirmationPage;
    private SignUpConfirmationPage signUpConfirmationPage;
    private HomePage homePage;

    //</editor-fold>

    //<editor-fold desc="BeforeClass, AfterClass, Before, After annotations">

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

        header = new Header(driver);
        forgotPasswordConfirmationPage = new ForgotPasswordConfirmationPage(driver);
        signUpConfirmationPage = new SignUpConfirmationPage(driver);
        homePage = new HomePage(driver);
    }

    //execute after each TC
    @After
    public void quitDriver() {
        driver.quit();
    }

    //</editor-fold>

    //<editor-fold desc="Rules declaration">

    //Timeout Rule that applies to all test cases in the test class
    @Rule
    public Timeout globalTimeout = Timeout.seconds(300);


    //Rerun failed tests 3 times
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    //</editor-fold>

    //log in
    @Test
    public void logIn(){

        //log in using "qacrispus@gmail.com" account
        header.openLogInForm()
                .loginAs(ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"), ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));

        //check username
        Assert.assertEquals(ReadXMLFile.takeConstantFromXML("Account", "Main", "userName"), header.getUserName());

    }

    //check forgot password flow
    @Test
    public void forgotPasswordFlow(){

        header.openLogInForm()              //click on Log in link
                .goToForgotPasswordPage()   //go to Forgot password page
                .goToForgotPasswordConfirmationPage(ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress")); //type email and click on Forgot password button

        //check URL
        Assert.assertTrue(forgotPasswordConfirmationPage.checkUrl());
    }

    //sign up without review flow
    @Test
    public void signUpWithoutReview(){

        header.goToSignUpPage()      //go to Sign Up page
                .signUpRandom();     //sign Up via random email

        //verify that current URL is correct
        Assert.assertTrue(signUpConfirmationPage.checkUrl());

        //verify that current logged user has correct profile user name
        Assert.assertTrue(header.checkUserNameForRandomCreatedUser());

        //Find Treatments button exists
        Assert.assertTrue(signUpConfirmationPage.checkTreatmentsButtonIsDisplayed());

        // Write a Review button exists
        Assert.assertTrue(signUpConfirmationPage.checkWriteAReviewButtonIsDisplayed());
    }

    //Write a Review, logged out user, condition is unknown
    @Test
    public void writeAReviewLoggedOutUserConditionIsUnknown(){

        homePage.goToWriteAReviewPage()
                .writeAReview(
                        ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"),
                        ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"),
                        "Male",
                        "0 - 6 Months",
                        "0 - 4 hours",
                        "Yes")
                .isSignUpFormVisible();

    }

}
