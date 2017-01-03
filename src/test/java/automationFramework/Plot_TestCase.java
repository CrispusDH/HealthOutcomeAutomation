package automationFramework;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectsActions.*;
import pageObjectsElements.*;
import utility.RandomNumber;
import utility.ReadXMLFile;
import utility.SetDriver;
import static org.junit.Assert.*;

public class Plot_TestCase {
    //driver initialize
    private static WebDriver driver = null;

    @Rule
    public TestName name = new TestName();

    @Before
    public void createNewDriver() {
        SetDriver.setChromeDriver();
        driver = new ChromeDriver();
        driver.get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));
    }

    //execute after each TC
    @After
    public void wipeDriver(){
        driver.quit();
    }


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
        HeaderActions.clickOnSignUp(driver);
        SignUpPageActions.SignUp_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "SignUp Confirmation Page", "url"), driver.getCurrentUrl()); //verify that current URL is correct
        assertEquals(HeaderElements.lnk_Profile(driver).getText(), String.valueOf(RandomNumber.currentRandomNumber())); //verify that current logged user has correct profile user name
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed()); //Find Treatments button exists
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed()); // Write a Review button exists
    }


        /*
    //проверка работы, временный тест
    @Test
    public void writeReviewLoggedOutUserTemp(){
        HomePageActions.goToWriteAReviewPage(driver);
        WriteAReviewPageActions.chooseBodyArea(driver, "SHOULDER");
        WriteAReviewPageActions.chooseCondition(driver, "Frozen Shoulder");
        //WriteAReviewPageActions.fillAndPostReview(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"), ReadXMLFile.takeConstantFromXML("Treatment", "NSAIDs - Anti Inflammatory drugs", "name"), ReadXMLFile.takeConstantFromXML("RateChoice", "Cured", "satisfactionLevel"));

    }
    */

}
