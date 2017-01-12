package automationFramework;


import junit.framework.TestCase;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjectsActions.*;
import pageObjectsElements.*;
import utility.RandomNumber;
import utility.ReadXMLFile;
import utility.SetDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Navigation_TestCase extends TestCase{

    //driver initialize
    private static WebDriver driver = null;
    private static ChromeDriverService service = null;

    @BeforeClass
    public static void createAndStartService() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(ReadXMLFile.takeConstantFromXML("ChromeDriver", "ChromeDriver", "path")))
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
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        driver.get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));
    }

    //execute after each TC
    @After
    public void quitDriver() {
        driver.quit();
    }

    //Navigation to Single Review page from Home page
    @Test
    public void goToSingleReviewPage(){
        HomePageActions.goToSingleReviewPage(driver);
        assertTrue(SingleReviewPageElements.div_ReviewInfo(driver).isDisplayed()); //check that div block with review exists and displayed
    }

    //Navigation to About page from Home page
    @Test
    public void checkFooterLinkAbout(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "About", "linkName"));
        assertTrue(!(AboutUsPageElements.paragraphs(driver).isEmpty()));// check that AboutUS body are not empty
        assertTrue((AboutUsPageElements.paragraphs(driver).size() > 0)); // check the same in another way
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "About Us", "url"), driver.getCurrentUrl()); //check URL

    }

    //Navigation to FAQ page from Home page
    @Test
    public void checkFooterLinkFAQ(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "FAQ", "linkName"));
        assertTrue(!(FAQPageElements.questions(driver).isEmpty()));// check that cards are on that page
        assertTrue((FAQPageElements.questions(driver).size() > 0)); // check the same in another way (two elements are buttons and other elements should be blogs)
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "FAQ", "url"), driver.getCurrentUrl()); //check URL
    }

    //Navigation to Blog page from Home page
    @Test
    public void checkFooterLinkBlog(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Blog", "linkName"));
        assertTrue(!(BlogPageElements.blogs(driver).isEmpty()));// check that cards are on that page
        assertTrue((BlogPageElements.blogs(driver).size() > 2)); // check the same in another way (two elements are buttons and other elements should be blogs)
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Blog", "url"), driver.getCurrentUrl()); //check URL
    }

    //Navigation to Resources page from Home page
    @Test
    public void checkFooterLinkResources(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Resources", "linkName"));
        assertTrue(!(ResourcesPageElemetns.resources(driver).isEmpty()));// check that cards are on that page
        assertTrue((ResourcesPageElemetns.resources(driver).size() > 0)); // check the same in another way
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Resources", "url"), driver.getCurrentUrl()); //check URL
    }

    //Navigation to Testimonials page from Home page
    @Test
    public void checkFooterLinkTestimonials(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Testimonials", "linkName"));
        assertTrue(!(TestimonialsPageElements.cards(driver).isEmpty()));// check that cards are on that page
        assertTrue(TestimonialsPageElements.cards(driver).size() > 0); // check the same in another way
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Testimonials", "url"), driver.getCurrentUrl()); //check URL
    }

    //Navigation to Contact Us page from Home page
    @Test
    public void checkFooterLinkContactUs(){
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Contact Us", "linkName"));
        assertTrue((ContactUsPageElements.div_ContactForm(driver).isDisplayed()));// check that Contact Form on the page
        assertTrue((ContactUsPageElements.contactItems(driver).size() == 3));// check that all items are on page
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Contact Us", "url"), driver.getCurrentUrl()); //check URL

    }

    //Navigation to Privacy Policy page from Home page
    @Test
    public void checkFooterCopyrightPrivacyPolicy(){

        FooterActions.clickOnFooterCopyright(driver, ReadXMLFile.takeConstantFromXML("FooterCopyright", "Privacy Policy", "copyrightName"));
        assertTrue((PrivacyPolicyPageElements.paragraphs(driver).size() >  10)); //check that page has text
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Privacy Policy", "url"), driver.getCurrentUrl()); //check URL

    }

    //Navigation to Terms of Service page from Home page
    @Test
    public void checkFooterCopyrightTermsOfService(){

        FooterActions.clickOnFooterCopyright(driver, ReadXMLFile.takeConstantFromXML("FooterCopyright", "Terms of Service", "copyrightName"));
        assertTrue((TermsOfServicePageElements.paragraphs(driver).size() >  50)); //check that page has text
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Terms of Service", "url"), driver.getCurrentUrl()); //check URL

    }


    //Navigation to Treatment Ratings Condition page from Home page
    @Test
    public void goToTreatmentRatingsConditionPage(){
        String expectedURL = HomePageElements.li_FeaturedConditions(driver).getAttribute("href");
        HomePageActions.goToFeaturedConditionPage(driver);
        assertEquals(expectedURL, driver.getCurrentUrl());
    }

    //Navigation to Condition Selection page from Home page
    @Test
    public void goToConditionSelectionPage() {

        String expectedURL  = HomePageElements.bttn_GetStarted(driver).getAttribute("href");
        HomePageActions.clickGetStartedButton(driver);
        assertEquals(expectedURL, driver.getCurrentUrl());

    }

    //Navigation to Treatment Ratings Condition page from the Condition Selection page
    @Test
    public void goToTreatmentRatingsConditionPageFromConditionSelectionPage() {

        String previousURL;
        String currentURL;
        HomePageActions.clickGetStartedButton(driver);
        previousURL = driver.getCurrentUrl();
        ConditionSelectionPageActions.goToTreatmentRatingsConditionPage(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        currentURL = driver.getCurrentUrl();
        assertNotEquals(previousURL, currentURL);


    }

    //Navigation to Condition Selection page from the Treatment Ratings Condition page
    @Test
    public void goToConditionSelectionPageFromTreatmentRatingsConditionPage() {

        String previousURL;
        String currentURL;

        HomePageActions.goToFeaturedConditionPage(driver);
        previousURL = driver.getCurrentUrl();
        TreatmentRatingsConditionPageActions.goToConditionSelectionPage(driver);
        currentURL = driver.getCurrentUrl();
        assertNotEquals(previousURL, currentURL);
    }

    //Navigation to Facebook page from Footer
    @Test
    public void goToFacebookPageFromFooter(){

        FooterActions.clickOnFootterConnect(driver, "facebook");

        ArrayList<String> currentTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(currentTab.get(1));
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Facebook", "url" ), driver.getCurrentUrl());

    }

    //Navigation to Twitter page from Footer
    @Test
    public void goToTwitterPageFromFooter(){

        String currentURL;
        FooterActions.clickOnFootterConnect(driver, "twitter");

        ArrayList<String> currentTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(currentTab.get(1));
        currentURL = driver.getCurrentUrl();
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Twitter", "url" ), currentURL);

    }

    //Check Linkedin page from Footer
    @Test
    public void goToLinkedinPageFromFooter(){

        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Linkedin", "href" ), FooterElements.link_Connect(driver, "linkedin").getAttribute("href"));

    }

    //Check mail href service from Footer
    @Test
    public void goToMailServiceFromFooter(){


        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Mail", "href" ), FooterElements.link_Connect(driver, "mail").getAttribute("href"));


    }

}
