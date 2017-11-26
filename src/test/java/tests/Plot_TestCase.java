package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pages.RegistrationVerifyPage;
import utility.RandomNumber;
import utility.ReadXMLFile;
import wrappers.BaseTest;

import static enums.WriteAReviewEnums.GenderOptions.*;
import static enums.WriteAReviewEnums.PhysicalActivityOptions.*;
import static enums.WriteAReviewEnums.RepeatOptions.*;
import static enums.WriteAReviewEnums.SufferedOptions.*;

@RunWith(JUnit4.class)
public class Plot_TestCase extends BaseTest {

    //log in
    @Test
    public void logIn(){

        //log in using "qacrispus@gmail.com" account
        openHomePage()
                .getHeader()
                .openLogInForm()
                .loginAs(ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"),
                        ReadXMLFile.takeConstantFromXML("Account", "Main", "password"))
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
                .goToForgotPasswordConfirmationPage(ReadXMLFile.takeConstantFromXML(
                        "Account",
                        "Main",
                        "emailAddress"))  //type email and click on Forgot password button
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
                        ZERO_TO_SIX,
                        ZERO_TO_FOUR,
                        YES)
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

    //Fill your Free private account and go to Registration Verify page
    @Test
    public void fillFormForFreePrivateAccount(){
        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .goToFirstStepOfCoachingProgramPage()
                .writeAReview()
                .fillForm(
                        "Oleksii Ihnatiuk",
                    RandomNumber.createRandomNumber
                        (
                            0,
                            999999999
                        ) + "@gmail.com",
                    String.valueOf(RandomNumber.currentRandomNumber()) + "@gmail.com",
                        "lytghjgtnhjdcr");
        new RegistrationVerifyPage()
                .checkEmail();
    }

}