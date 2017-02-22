package automationFramework;


import PageObject.*;
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
public class Navigation_TestCase extends TestCase{

    //<editor-fold desc="Initialisation block">

    private WebDriver driver;
    private static ChromeDriverService service;

    private HomePage homePage;
    private SingleReviewPage singleReviewPage;
    private Footer footer;
    private AboutUsPage aboutUsPage;
    private FAQPage faqPage;

    //</editor-fold>

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

        homePage = new HomePage(driver);
        singleReviewPage = new SingleReviewPage(driver);
        footer = new Footer(driver);
        aboutUsPage = new AboutUsPage(driver);
        faqPage = new FAQPage(driver);
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
        homePage.goToSingleReviewPage();

        //check that div block with review exists and displayed
        assertTrue(singleReviewPage.isOnPage());

    }

    //Navigation to About page from Home page
    @Test
    public void checkFooterLinkAbout(){

        //go to About page from Footer
        footer.goToAboutUsPage();

        //check that About US body are not empty
        assertTrue(!aboutUsPage.bodyIsEmpty());

        //check that About Us page has paragraphs
        assertTrue(aboutUsPage.amountOfParagraphs());

        //check URL
        assertTrue(aboutUsPage.checkUrl());

    }

    //Navigation to FAQ page from Home page
    @Test
    public void checkFooterLinkFAQ(){

        //go to FAQ page
        footer.goToFAQPage();

        //check that FAQ body are not empty
        assertTrue(!faqPage.bodyIsEmpty());

        //check that FAQ page has paragraphs
        assertTrue(faqPage.amountOfQustions());

        //check URL
        assertTrue(faqPage.checkUrl());
    }
/*
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
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

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
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

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
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

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
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

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
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

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

    //Navigation to Treatment Reviews page from Treatment Ratings Condition page
    @Test
    public void goToTreatmentReviewsPageFromTreatmentRatingsConditionPage(){

        //create variable
        String expectedURL;

        //go to Treatment Ratings Condition page
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

        //save expected url
        expectedURL =  driver.getCurrentUrl() + "-reviews";

        //go to Treatment Reviews page (click on Treatment Reviews tab)
        TreatmentRatingsConditionPageActions.clickOnTab(driver, "Treatment Reviews");

        //check URL
        assertEquals(expectedURL, driver.getCurrentUrl());

    }

    //Navigation to Write a Review page from Treatment Reviews page
    @Test
    public void goToWriteAReviewPageFromTreatmentReviewsPage(){

        //go to Treatment Ratings Condition page
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

        //go to Treatment Reviews page (click on Treatment Reviews tab)
        TreatmentRatingsConditionPageActions.clickOnTab(driver, "Treatment Reviews");

        //go to Write a Review page (click on "Share your Experience" button)
        TreatmentReviewsPageActions.clickOnShareYourExperienceButton(driver);

        //check URL
        assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Reviews", "url"), driver.getCurrentUrl());

        //check group title
        assertEquals("What is your gender?", WriteAReviewPageElements.text_GroupTitle(driver).getText());

    }

    //Navigation to Specific Videos&Guides Treatment page from Treatment Rating -> Specific Treatment Review page
    @Test
    public void goToSpecificVideosAndGuidesPageFromSpecificTreatmentReviewPage(){

        //create variable
        String expectedURL;

        //go to Treatment Ratings Condition page
        HomePageActions.goToTreatmentRatingsConditionPage(driver);

        //go to Specific Treatment Review page
        TreatmentRatingsConditionPageActions.goInToSpecificTreatment(driver, "Massage");

        //save expected url
        expectedURL =  driver.getCurrentUrl() + "-recommendations";

        //go to Specific Videos&Guides Treatment page
        SpecificTreatmentReviewsPageActions.clickOnTab(driver, "Videos & Guides");

        //check URL
        assertEquals(expectedURL, driver.getCurrentUrl());

    }
*/
}
