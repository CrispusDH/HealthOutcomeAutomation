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
import utility.ReadXMLFile;
import utility.RetryRule;

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


    //Navigation to Single Review page from Home page
    @Test
    public void goToSingleReviewPage(){

        //go to Single Review page from Home page
        HomePageActions.goToSingleReviewPage(driver);

        //check that div block with review exists and displayed
        assertTrue(SingleReviewPageElements.div_ReviewInfo(driver).isDisplayed());
    }

    //Navigation to About page from Home page
    @Test
    public void checkFooterLinkAbout(){

        //go to About page from Footer
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "About", "linkName"));

        //check that AboutUS body are not empty
        assertTrue(!(AboutUsPageElements.paragraphs(driver).isEmpty()));

        //check the same in another way
        assertTrue((AboutUsPageElements.paragraphs(driver).size() > 0));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "About Us", "url"), driver.getCurrentUrl());

    }

    //Navigation to FAQ page from Home page
    @Test
    public void checkFooterLinkFAQ(){

        //go to FAQ page
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "FAQ", "linkName"));

        //check that cards are on that page
        assertTrue(!(FAQPageElements.questions(driver).isEmpty()));

        //check the same in another way (two elements are buttons and other elements should be blogs)
        assertTrue((FAQPageElements.questions(driver).size() > 0));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "FAQ", "url"), driver.getCurrentUrl());
    }

    //Navigation to Blog page from Home page
    @Test
    public void checkFooterLinkBlog(){

        //go to Blog page
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Blog", "linkName"));

        //check that cards are on that page
        assertTrue(!(BlogPageElements.blogs(driver).isEmpty()));

        //check the same in another way (two elements are buttons and other elements should be blogs)
        assertTrue((BlogPageElements.blogs(driver).size() > 2));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Blog", "url"), driver.getCurrentUrl());
    }

    //Navigation to Resources page from Home page
    @Test
    public void checkFooterLinkResources(){

        //go to Resources page
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Resources", "linkName"));

        //check that cards are on that page
        assertTrue(!(ResourcesPageElemetns.resources(driver).isEmpty()));

        //check the same in another way
        assertTrue((ResourcesPageElemetns.resources(driver).size() > 0));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Resources", "url"), driver.getCurrentUrl());
    }

    //Navigation to Testimonials page from Home page
    @Test
    public void checkFooterLinkTestimonials(){

        //go to Testimonials page
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Testimonials", "linkName"));

        //check that cards are on that page
        assertTrue(!(TestimonialsPageElements.cards(driver).isEmpty()));

        //check the same in another way
        assertTrue(TestimonialsPageElements.cards(driver).size() > 0);

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Testimonials", "url"), driver.getCurrentUrl());
    }

    //Navigation to Contact Us page from Home page
    @Test
    public void checkFooterLinkContactUs(){

        //go to Contact Us
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Contact Us", "linkName"));

        //check that Contact Form on the page
        assertTrue((ContactUsPageElements.div_ContactForm(driver).isDisplayed()));

        //check that all items are on page
        assertTrue((ContactUsPageElements.contactItems(driver).size() == 3));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Contact Us", "url"), driver.getCurrentUrl());

    }

    //Navigation to Privacy Policy page from Home page
    @Test
    public void checkFooterCopyrightPrivacyPolicy(){

        //go to Privacy Policy page
        FooterActions.clickOnFooterCopyright(driver, ReadXMLFile.takeConstantFromXML("FooterCopyright", "Privacy Policy", "copyrightName"));

        //check that page has text
        assertTrue((PrivacyPolicyPageElements.paragraphs(driver).size() >  10));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Privacy Policy", "url"), driver.getCurrentUrl());

    }

    //Navigation to Terms of Service page from Home page
    @Test
    public void checkFooterCopyrightTermsOfService(){

        //go to Terms of Service page
        FooterActions.clickOnFooterCopyright(driver, ReadXMLFile.takeConstantFromXML("FooterCopyright", "Terms of Service", "copyrightName"));

        //check that page has text
        assertTrue((TermsOfServicePageElements.paragraphs(driver).size() >  50));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Terms of Service", "url"), driver.getCurrentUrl());

    }


    //Navigation to Treatment Ratings Condition page from Home page
    @Test
    public void goToTreatmentRatingsConditionPage(){

        //find and save expected url
        String expectedURL = HomePageElements.li_FeaturedConditions(driver).getAttribute("href");

        //go to Treatment Ratings Condition page
        HomePageActions.goToFeaturedConditionPage(driver);

        //check URL
        assertEquals(expectedURL, driver.getCurrentUrl());
    }

    //Navigation to Condition Selection page from Home page
    @Test
    public void goToConditionSelectionPage() {

        //find and save expected URL
        String expectedURL  = HomePageElements.button_GetStarted(driver).getAttribute("href");

        //click on Get Started button
        HomePageActions.clickGetStartedButton(driver);

        //check URL
        assertEquals(expectedURL, driver.getCurrentUrl());

    }

    //Navigation to Treatment Ratings Condition page from the Condition Selection page
    @Test
    public void goToTreatmentRatingsConditionPageFromConditionSelectionPage() {

        //create variables
        String previousURL;
        String currentURL;

        //click Get Started button
        HomePageActions.clickGetStartedButton(driver);

        //save current URL
        previousURL = driver.getCurrentUrl();

        //go to Treatment Ratings Condition page
        ConditionSelectionPageActions.goToTreatmentRatingsConditionPage(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"));

        //wait 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //save current URL
        currentURL = driver.getCurrentUrl();

        //check that previous and current URLs are not equals
        assertNotEquals(previousURL, currentURL);

    }

    //Navigation to Condition Selection page from the Treatment Ratings Condition page
    @Test
    public void goToConditionSelectionPageFromTreatmentRatingsConditionPage() {

        //create variables
        String previousURL;
        String currentURL;

        //go to Treatment Ratings Condition page
        HomePageActions.goToFeaturedConditionPage(driver);

        //save current URL
        previousURL = driver.getCurrentUrl();

        //go to Condition Selection page
        TreatmentRatingsConditionPageActions.goToConditionSelectionPage(driver);

        //save current URL
        currentURL = driver.getCurrentUrl();

        //check that previous and current URLs are not equals
        assertNotEquals(previousURL, currentURL);
    }

    //Navigation to Facebook page from Footer
    @Test
    public void goToFacebookPageFromFooter(){

        //click on Facebook link
        FooterActions.clickOnFootterConnect(driver, "facebook");

        //switch to new window
        ArrayList<String> currentTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(currentTab.get(1));

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Facebook", "url" ), driver.getCurrentUrl());

    }

    //Navigation to Twitter page from Footer
    @Test
    public void goToTwitterPageFromFooter(){

        //create variable
        String currentURL;

        //click on Twitter link
        FooterActions.clickOnFootterConnect(driver, "twitter");

        //switch to new window
        ArrayList<String> currentTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(currentTab.get(1));

        //save current URL
        currentURL = driver.getCurrentUrl();

        //check URL
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

    //Navigation to Write a Review page from Blog page
    @Test
    public void goToWriteAReviewPageFromBlogPage(){

        //go to Blog page
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Blog", "linkName"));

        //go to Write a Review page
        BlogPageActions.clickOnStartHereButton(driver);

        //verify that we are at the right page
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review Page", "fromBlogPage" ), driver.getCurrentUrl());

    }

    //Navigation to Write a Review page from Detailed Blog page
    @Test
    public void goToWriteAReviewPageFromDetailedBlogPage(){

        //go to Blog page
        FooterActions.clickOnFooterLink(driver, ReadXMLFile.takeConstantFromXML("FooterLink", "Blog", "linkName"));

        //go to Detailed Blog page
        BlogPageActions.clickOnSpecificBlog(driver);

        //wait until page is loaded
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //go to Write a Review page
        DetailedBlogPageActions.clickOnStartHereButton(driver);

        //verify that we are at the right page
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review Page", "fromDetailedBlogPage" ), driver.getCurrentUrl());

    }

    //Navigation to 1st step of Coaching Program Write Coaching Request page from Treatment Ratings Condition page
    @Test
    public void goToFirstStepOfCoachingProgramFromTreatmentRatingsConditionPage(){

        //go to Treatment Ratings Condition page
        HomePageActions.goToFeaturedConditionPage(driver);

        //wait until page is loaded
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //go to 1st step of Coaching Program Write Coaching Request page
        TreatmentRatingsConditionPageActions.goToFirstStepOfCoachingProgram(driver);

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "First Step Of Coaching Program", "url" ), driver.getCurrentUrl());

    }

    //Navigation to Videos&Guides Condition page from Treatment Ratings Condition page
    @Test
    public void goToVideosAndGuidesConditionPageFromTreatmentRatingsConditionPage(){

        //create variable
        String expectedURL;

        //go to Treatment Ratings Condition page
        HomePageActions.goToFeaturedConditionPage(driver);

        //save expected url
        expectedURL =  driver.getCurrentUrl() + "-videos";

        //go to Videos&Guides Condition page
        TreatmentRatingsConditionPageActions.clickOnTab(driver, "Videos & Guides");

        //check URL
        assertEquals(expectedURL, driver.getCurrentUrl());

    }

    //Navigation to Sign Up page from Videos&Guides Condition page
    @Test
    public void goToSignUpPageFromVideosAndGuidesConditionPage(){

        //go to Treatment Ratings Condition page
        HomePageActions.goToFeaturedConditionPage(driver);

        //go to Videos&Guides Condition page
        TreatmentRatingsConditionPageActions.clickOnTab(driver, "Videos & Guides");

        //go to Sign Up page
        HeaderActions.clickOnSignUp(driver);

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "SignUp Page from Videos&Guides Page", "url"), driver.getCurrentUrl());

        //check that Join Now button exists
        assertTrue(SignUpPageElements.button_JoinNow(driver).isDisplayed());

        //check that Sign up with Facebbok button exists
        assertTrue(SignUpPageElements.button_SignUpWithFacebook(driver).isDisplayed());

    }

    //Navigation to Write a Review page from Treatment Ratings Condition page
    @Test
    public void goToWriteAReviewPageFromTreatmentRatingsConditionPage(){

        //click Get Started button
        HomePageActions.clickGetStartedButton(driver);

        //go to Treatment Ratings Condition page
        ConditionSelectionPageActions.goToTreatmentRatingsConditionPage(driver, ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"));

        //wait 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //go to Write a Review page
        TreatmentRatingsConditionPageActions.clickOnShareYourExperienceButton(driver);

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Ratings Condition", "url"), driver.getCurrentUrl());

    }

}
