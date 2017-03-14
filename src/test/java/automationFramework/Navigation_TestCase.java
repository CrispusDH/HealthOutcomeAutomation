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
import utility.ReadXMLFile;
import utility.RetryRule;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotEquals;


@RunWith(JUnit4.class)
public class Navigation_TestCase extends TestCase{

    //<editor-fold desc="Initialisation block">

    private WebDriver driver;
    private static ChromeDriverService service;

    private HomePage homePage;
    private Footer footer;
    private Header header;

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


    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }


    @Before
    public void createNewDriver() {

        driver = new RemoteWebDriver(service.getUrl(),
                        DesiredCapabilities.chrome());

        driver.get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));

        homePage = new HomePage(driver);
        footer = new Footer(driver);
        header = new Header(driver);

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

    //Navigation to Single Review page from Home page
    @Test
    public void goToSingleReviewPage(){

        homePage.goToSingleReviewPage()     //go to Single Review page from Home page
                .isReviewInfoOnPage();      //check that div block with review exists and displayed

    }

    //Navigation to About page from Home page
    @Test
    public void checkFooterLinkAbout(){

        //go to About page from Footer
        footer.goToAboutUsPage()
                .checkIsEmpty()    //check that About US body are not empty
                .checkAmountOfParagraphs()  //check that About Us page has paragraphs
                .checkUrl();    //check About Us url

    }

    //Navigation to FAQ page from Home page
    @Test
    public void checkFooterLinkFAQ(){

        //go to FAQ page
        footer.goToFAQPage()
                .checkIsBodyEmpty()  //check that FAQ body are not empty
                .checkAmountOfQustions() //check that FAQ page has paragraphs
                .checkUrl();    //check URL

    }

    //Navigation to Blog page from Home page
    @Test
    public void checkFooterLinkBlog(){

        //go to Blog page
        footer.goToBlogPage()
                .checkIsBodyEmpty() //check that blogs are on that page
                .checkAmountOfBlogs()   //check that blogs are more than 0
                .checkUrl();  //check URL

    }

    //Navigation to Resources page from Home page
    @Test
    public void checkFooterLinkResources(){

        //go to Resources page
        footer.goToResourcesPage()
                .checkIsBodyEmpty() //check that resources are on that page
                .checkAmountOfResources()   //check that resources more than 0
                .checkUrl();   //check URL

    }

    //Navigation to Testimonials page from Home page
    @Test
    public void checkFooterLinkTestimonials(){

        //go to Testimonials page
        footer.goToTestimonialsPage()
                .checkIsBodyEmpty() //check that cards are on that page
                .checkAmountOfCards()   //check the same in another way
                .checkUrl();    //check URL

    }

    //Navigation to Contact Us page from Home page
    @Test
    public void checkFooterLinkContactUs(){

        //go to Contact Us
        footer.goToContactUsPage()
                .checkIsBodyEmpty() //check that Contact Form on the page
                .checkAmountOfItems()   //check that all items are on page
                .checkUrl();    //check URL

    }

    //Navigation to Privacy Policy page from Home page
    @Test
    public void checkFooterCopyrightPrivacyPolicy(){

        //go to Privacy Policy page
        footer.goToPrivacyPolicyPage()
                .checkAmountOfParagraphs()  //check that page has text
                .checkUrl();    //check URL

    }

    //Navigation to Terms of Service page from Home page
    @Test
    public void checkFooterCopyrightTermsOfService(){

        //go to Terms of Service page
        footer.goToTermsOfServicePage()
                .checkAmountOfParagraphs()  //check that page has text
                .checkUrl();    //check URL

    }

    //Navigation to Treatment Ratings Condition page from Home page
    @Test
    public void goToTreatmentRatingsConditionPage(){

        //get Featured Condition url and set it as expected url
        String expectedUrl = homePage.getFeaturedConditionUrl();

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage()
                .checkURL(expectedUrl); //check URL

    }

    //Navigation to Condition Selection page from Home page
    @Test
    public void goToConditionSelectionPage() {

        //find and save expected URL
        String expectedURL  = homePage.getGetStartedButtonUrl();

        //go to Condition Selection page
        homePage.goToConditionSelectionPage()
                .checkURL(expectedURL); //check URL

    }

    //Navigation to Treatment Ratings Condition page from the Condition Selection page
    @Test
    public void goToTreatmentRatingsConditionPageFromConditionSelectionPage() {

        //go to Condition Selection page
        homePage.goToConditionSelectionPage()
                .goToTreatmentRatingsConditionPage(ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"));

    }

    //Navigation to Condition Selection page from the Treatment Ratings Condition page
    @Test
    public void goToConditionSelectionPageFromTreatmentRatingsConditionPage() {

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage()
                .goToConditionSelectionPage();  //go to Condition Selection page

    }

    //Navigation to Facebook page from Footer
    @Test
    public void goToFacebookPageFromFooter(){

        //go to Facebook
        footer.goToFacebookPage()
                .checkUrl();   //check URL

    }

    //Navigation to Twitter page from Footer
    @Test
    public void goToTwitterPageFromFooter(){

        //go to Twitter
        footer.goToTwitterPage()
                .checkUrl();    //check URL

    }

    //Check Linkedin href from Footer
    @Test
    public void checkLinkedinUrl(){

        Assert.assertTrue(footer.checkLinkedingUrl());

    }

    //Check mail href service from Footer
    @Test
    public void goToMailServiceFromFooter(){

        Assert.assertTrue(footer.checkMailUrl());

    }

    //Navigation to Write a Review page from Blog page
    @Test
    public void goToWriteAReviewPageFromBlogPage(){


        footer.goToBlogPage()            //go to Blog page
                .goToWriteAReviewPage() //go to Write a Review page
                .checkURLBasic();    //verify that we are at the right page

    }

    //Navigation to Write a Review page from Detailed Blog page
    @Test
    public void goToWriteAReviewPageFromDetailedBlogPage(){


        footer.goToBlogPage()                           //go to Blog page
                .goToDetailedBlogPage(1)    //go to Detailed Blog page
                .goToWriteAReviewPage()                 //go to Write a Review page
                .checkURLBasic();                            //verify that we are at the right page

    }

    //Navigation to 1st step of Coaching Program Write Coaching Request page from Treatment Ratings Condition page
    @Test
    public void goToFirstStepOfCoachingProgramFromTreatmentRatingsConditionPage(){

        homePage.goToTreatmentRatingsConditionPage()    //go to Treatment Ratings Condition page
                .goToFirstStepOfCoachingProgramPage()   //go to 1st step of Coaching Program Write Coaching Request page
                .checkUrl();  //check URL

    }

    //Navigation to Videos&Guides Condition page from Treatment Ratings Condition page
    @Test
    public void goToVideosAndGuidesConditionPageFromTreatmentRatingsConditionPage(){

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage()
                .setExpectedVideosURL() //set expected url to static variable
                .goToTreatmentVideosPage()  //go to Videos&Guides Condition page
                .checkURL();    //check URL

    }

    //Navigation to Sign Up page from Videos&Guides Condition page
    @Test
    public void goToSignUpPageFromVideosAndGuidesConditionPage(){

        homePage.goToTreatmentRatingsConditionPage()    //go to Treatment Ratings Condition page
                .goToTreatmentVideosPage();             //go to Treatment Videos&Guides page

        //go to Sign Up page
        header.goToSignUpPage()
                .checkUrl() //check URL
                .checkIsJoinNowButtonExists()   //check that Join Now button exists
                .checkIsSignUpWithFacebookButtonExists();   //check that Sign up with Facebook button exists

    }

    //Navigation to Write a Review page from Treatment Ratings Condition page
    @Test
    public void goToWriteAReviewPageFromTreatmentRatingsConditionPage(){

        homePage.goToConditionSelectionPage()   //go to Condition Selection page
                .goToTreatmentRatingsConditionPage( ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name")) //go to Treatment Ratings Condition page
                .goToWriteAReviewPage() //go to Write a Review page
                .checkURLFromTreatmentRatingsCondition();   //check URL

    }

    //Navigation to Treatment Reviews page from Treatment Ratings Condition page
    @Test
    public void goToTreatmentReviewsPageFromTreatmentRatingsConditionPage(){

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage()
                .setExpectedReviewsURL()    //save expected url
                .goToTreatmentReviewsPage() //go to Treatment Reviews page (click on Treatment Reviews tab)
                .checkURL();    //check URL

    }

    //Navigation to Write a Review page from Treatment Reviews page
    @Test
    public void goToWriteAReviewPageFromTreatmentReviewsPage(){

        homePage.goToTreatmentRatingsConditionPage()    //go to Treatment Ratings Condition page
                .goToTreatmentReviewsPage() //go to Treatment Reviews page (click on Treatment Reviews tab)
                .goToWriteAReviewPage()    //go to Write a Review page (click on "Share your Experience" button)
                .checkURLFromTreatmentsReviews()    //check URL
                .checkGroupTitleInCaseOfFromTreatmentReviewsPage(); //check group title

    }

    //Navigation to Specific Videos&Guides Treatment page from Treatment Rating -> Specific Treatment Review page
    @Test
    public void goToSpecificVideosAndGuidesPageFromSpecificTreatmentReviewPage(){

        //create local variable
        String expectedURL;

        homePage.goToTreatmentRatingsConditionPage()               //go to Treatment Ratings Condition page
                .goToSpecificTreatment("Massage")   //go to Specific Treatment Review page
                .setExpectedSpecificTreatmentVideosPageURL()    //save expected url
                .goToSpecificTreatmentVideosPage()  //go to Specific Videos&Guides Treatment page
                .checkURL();    //check URL

    }

}
