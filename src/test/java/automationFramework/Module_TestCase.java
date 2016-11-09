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

public class Module_TestCase {
    private static WebDriver driver = null;

    @Rule
    public TestName name = new TestName();

    @Before
    public void createNewDriver() {
        SetDriver.setChromeDriver();
        driver = new ChromeDriver();
        driver.get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));
    }

    /*@After
    public void wipeDriver(){
        driver.quit();
    }*/


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
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "ForgotPasswordConfirm", "url"), driver.getCurrentUrl());
    }

    @Test
    public void writeReviewLoggedOutUser(){
        HomePageActions.goToWriteAReviewPage(driver);
        WriteAReviewPageActions.fillAndPostReview(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"), ReadXMLFile.takeConstantFromXML("Treatment", "NSAIDs - Anti Inflammatory drugs", "name"), ReadXMLFile.takeConstantFromXML("RateChoice", "Cured", "satisfactionLevel"));
        assertTrue(WriteAReviewConfirmationPageElements.frm_SignUp(driver).isDisplayed());
    }

    @Test
    public void writeReviewLoggedInUserConditionIsUnknown(){
        HeaderActions.clickOnLogIn(driver);
        HomePageActions.logIn_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "emailAddress"), ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        HomePageActions.goToWriteAReviewPage(driver);
        WriteAReviewPageActions.fillAndPostReview(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"),ReadXMLFile.takeConstantFromXML("Treatment", "NSAIDs - Anti Inflammatory drugs", "name"), ReadXMLFile.takeConstantFromXML("RateChoice", "Cured", "satisfactionLevel"));
        assertTrue(WriteAReviewConfirmationPageElements.txt_ReviewUserName(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "userName")).isDisplayed()); //check that a review by current User exists
    }

/*
    @Test
    public void signUpAfterWritingReview(){
        HomePageActions.goToWriteAReviewPage(driver);
        WriteAReviewPageActions.fillAndPostReview(driver, ReadXMLFile.takeConstantFromXML("Treatment", "NSAIDs - Anti Inflammatory drugs", "name"));
        HeaderActions.clickOnSignUp(driver);
        SignUpPageActions.SignUp_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "SignUpConfirmationPage", "url"), driver.getCurrentUrl()); //verify that current URL is correct
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed()); //Find Treatments button exists
        assertTrue(!(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed())); // Write a Review button should not be
    }*/

    @Test
    public void signUpWithoutReview(){
        HeaderActions.clickOnSignUp(driver);
        SignUpPageActions.SignUp_Execute(driver, ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "SignUpConfirmationPage", "url"), driver.getCurrentUrl()); //verify that current URL is correct
        assertEquals(HeaderElements.lnk_Profile(driver).getText(), String.valueOf(RandomNumber.currentRandomNumber())); //verify that current logged user has correct profile user name
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed()); //Find Treatments button exists
        assertTrue(SignUpConfirmationPageElements.bttn_WriteAReviewOrFindTreatments(driver, ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed()); // Write a Review button exists
    }

    @Test
    public void goToSingleReviewPage(){
        HomePageActions.goToSingleReviewPage(driver);
        assertTrue(SingleReviewPageElements.div_ReviewInfo(driver).isDisplayed()); //check that div block with review exists and displayed
    }

    @Test
    public void checkFooterLinkAbout(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "About", "linkName"));
        assertTrue(!(AboutUsPageElements.paragraphs(driver).isEmpty()));// check that AboutUS body are not empty
        assertTrue((AboutUsPageElements.paragraphs(driver).size() > 0)); // check the same in another way
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "AboutUs", "url"), driver.getCurrentUrl()); //check URL

    }

    @Test
    public void checkFooterLinkFAQ(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "FAQ", "linkName"));
        assertTrue(!(FAQPageElements.questions(driver).isEmpty()));// check that cards are on that page
        assertTrue((FAQPageElements.questions(driver).size() > 0)); // check the same in another way (two elements are buttons and other elements should be blogs)
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "FAQ", "url"), driver.getCurrentUrl()); //check URL
    }

    @Test
    public void checkFooterLinkBlog(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Blog", "linkName"));
        assertTrue(!(BlogPageElements.blogs(driver).isEmpty()));// check that cards are on that page
        assertTrue((BlogPageElements.blogs(driver).size() > 2)); // check the same in another way (two elements are buttons and other elements should be blogs)
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Blog", "url"), driver.getCurrentUrl()); //check URL
    }

    @Test
    public void checkFooterLinkResources(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Resources", "linkName"));
        assertTrue(!(ResourcesPageElemetns.resources(driver).isEmpty()));// check that cards are on that page
        assertTrue((ResourcesPageElemetns.resources(driver).size() > 0)); // check the same in another way
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Resources", "url"), driver.getCurrentUrl()); //check URL
    }

    @Test
    public void checkFooterLinkTestimonials(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Testimonials", "linkName"));
        assertTrue(!(TestimonialsPageElements.cards(driver).isEmpty()));// check that cards are on that page
        assertTrue(TestimonialsPageElements.cards(driver).size() > 0); // check the same in another way
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Testimonials", "url"), driver.getCurrentUrl()); //check URL
    }

}
