package automationFramework;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import pageObjectsActions.*;
import pageObjectsElements.*;
import utility.RandomNumber;
import utility.ReadXMLFile;
import utility.RetryRule;
import utility.SetDriver;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

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


    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }


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


    @Test
    public void logIn(){
        HeaderActions.clickOnLogIn(driver);
        HomePageActions.logIn_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"), ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        assertEquals(ReadXMLFile.takeConstantFromXML("Account", "Main", "userName"), HeaderElements.lnk_Profile(driver).getText());
    }

    @Test
    public void forgotPassword(){
        HeaderActions.clickOnLogIn(driver);
        HomePageActions.goToForgotPasswordPage(driver);
        ForgotPasswordPageActions.forgotPassword_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"));
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Forgot Password Confirm", "url"), driver.getCurrentUrl());
    }


    /*
    @Test
    public void writeReviewLoggedOutUser(){
        HomePageActions.goToWriteAReviewPage(driver);
        WriteAReviewPageActions.fillAndPostReview(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"), ReadXMLFile.takeConstantFromXML("Treatment", "NSAIDs - Anti Inflammatory drugs", "name"), ReadXMLFile.takeConstantFromXML("RateChoice", "Cured", "satisfactionLevel"));
        assertTrue(WriteAReviewConfirmationPageElements.frm_SignUp(driver).isDisplayed());
    }*/


    /*
    @Test
    public void writeReviewLoggedInUserConditionIsUnknown(){
        HeaderActions.clickOnLogIn(driver);
        HomePageActions.logIn_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"), ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        HomePageActions.goToWriteAReviewPage(driver);
        WriteAReviewPageActions.fillAndPostReview(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"),ReadXMLFile.takeConstantFromXML("Treatment", "NSAIDs - Anti Inflammatory drugs", "name"), ReadXMLFile.takeConstantFromXML("RateChoice", "Cured", "satisfactionLevel"));
        assertTrue(WriteAReviewConfirmationPageElements.txt_ReviewUserName(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "userName")).isDisplayed()); //check that a review by current User exists
    }*/

/*
    @Test
    public void signUpAfterWritingReview(){
        HomePageActions.goToWriteAReviewPage(driver);
        WriteAReviewPageActions.fillAndPostReview(driver, ReadXMLFile.takeConstantFromXML("Treatment", "NSAIDs - Anti Inflammatory drugs", "name"));
        HeaderActions.clickOnSignUp(driver);
        SignUpPageActions.SignUp_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "SignUp ConfirmationPage", "url"), driver.getCurrentUrl()); //verify that current URL is correct
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed()); //Find Treatments button exists
        assertTrue(!(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed())); // Write a Review button should not be
    }*/

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
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed());

        // Write a Review button exists
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed());
    }


}
