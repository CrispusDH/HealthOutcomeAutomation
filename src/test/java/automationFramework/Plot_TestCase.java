package automationFramework;

import PageObject.Header;
import PageObject.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.ReadXMLFile;
import utility.RetryRule;
import utility.WebDriverProvider;

@RunWith(JUnit4.class)
public class Plot_TestCase extends WebDriverProvider {

    //<editor-fold desc="Initialisation block">

    private Header header;
    private HomePage homePage;

    //</editor-fold>

    //<editor-fold desc="BeforeClass, AfterClass, Before, After annotations">

    //create new driver
    @Before
    public void createNewDriver() {

        this.setupDriver();

        getDriver().get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));

        header = new Header();
        homePage = new HomePage();
    }

    //execute after each TC
    @After
    public void quitDriver() {

        this.cleanUp();

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

        //check user name
        header.checkUserName();

    }

    //check forgot password flow
    @Test
    public void forgotPasswordFlow(){

        header.openLogInForm()
                .goToForgotPasswordPage()
                .goToForgotPasswordConfirmationPage(ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"))  //type email and click on Forgot password button
                .checkUrl();
    }

    //sign up without review flow
    @Test
    public void signUpWithoutReview(){

        header.goToSignUpPage()
                .signUpRandom()
                .checkUrl()
                .checkIsTreatmentsButtonDisplayed()
                .checkIsWriteAReviewButtonDisplayed();

        //verify that current logged user has correct profile user name
        header.checkUserNameForRandomCreatedUser();

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
