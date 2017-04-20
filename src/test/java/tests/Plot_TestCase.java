package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.BaseTest;
import utility.ReadXMLFile;

import static enums.WriteAReviewEnums.GenderOptions.*;

@RunWith(JUnit4.class)
public class Plot_TestCase extends BaseTest {

    //log in
    @Test
    public void logIn(){

        //log in using "qacrispus@gmail.com" account
        openHomePage()
                .getHeader()
                .openLogInForm()
                .loginAs(ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"), ReadXMLFile.takeConstantFromXML("Account", "Main", "password"))
                .getHeader()
                .checkUserName();

    }

    //check forgot password flow
    @Test
    public void forgotPasswordFlow(){

        openHomePage()
                .getHeader()
                .openLogInForm()
                .goToForgotPasswordPage()
                .goToForgotPasswordConfirmationPage(ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"))  //type email and click on Forgot password button
                .checkUrl();
    }

    //sign up without review flow
    @Test
    public void signUpWithoutReview(){

        openHomePage()
                .getHeader()
                .goToSignUpPage()
                .signUpRandom()
                .checkUrl()
                .checkIsTreatmentsButtonDisplayed()
                .checkIsWriteAReviewButtonDisplayed()
                .getHeader()
                .checkUserNameForRandomCreatedUser();

    }

    //Write a Review, logged out user, condition is unknown
    @Test
    public void writeAReviewLoggedOutUserConditionIsUnknown(){

        openHomePage()
                .goToWriteAReviewPage()
                .writeAReview(
                        ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"),
                        ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"),
                        MALE,
                        "0 - 6 Months",
                        "0 - 4 hours",
                        "Yes")
                .isSignUpFormVisible();

    }

    //Write a Treatment History
    @Test
    public void writeATreatmentHistory(){

        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .goToFirstStepOfCoachingProgramPage()
                .writeAReview()
                .checkGetStartedButtonIsExist();

    }

}