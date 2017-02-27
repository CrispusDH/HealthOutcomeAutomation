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
    private SingleReviewPage singleReviewPage;
    private Footer footer;
    private AboutUsPage aboutUsPage;
    private FAQPage faqPage;
    private BlogPage blogPage;
    private ResourcesPage resourcesPage;
    private TestimonialsPage testimonialsPage;
    private ContactUsPage contactUsPage;
    private PrivacyPolicyPage privacyPolicyPage;
    private TermsOfServicePage termsOfServicePage;
    private TreatmentRatingsConditionPage treatmentRatingsConditionPage;
    private ConditionSelectionPage conditionSelectionPage;
    private FacebookPage facebookPage;
    private TwitterPage twitterPage;
    private WriteAReviewPage writeAReviewPage;
    private FirstStepOfCoachingProgramPage firstStepOfCoachingProgramPage;
    private TreatmentVideosPage treatmentVideosPage;
    private Header header;
    private SignUpPage signUpPage;
    private TreatmentReviewsPage treatmentReviewsPage;
    private SpecificTreatmentReviewsPage specificTreatmentReviewsPage;
    private SpecificTreatmentVideosPage specificTreatmentVideosPage;

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
        singleReviewPage = new SingleReviewPage(driver);
        footer = new Footer(driver);
        aboutUsPage = new AboutUsPage(driver);
        faqPage = new FAQPage(driver);
        blogPage = new BlogPage(driver);
        resourcesPage = new ResourcesPage(driver);
        testimonialsPage = new TestimonialsPage(driver);
        contactUsPage = new ContactUsPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        termsOfServicePage = new TermsOfServicePage(driver);
        treatmentRatingsConditionPage = new TreatmentRatingsConditionPage(driver);
        conditionSelectionPage = new ConditionSelectionPage(driver);
        facebookPage = new FacebookPage(driver);
        twitterPage = new TwitterPage(driver);
        writeAReviewPage = new WriteAReviewPage(driver);
        firstStepOfCoachingProgramPage = new FirstStepOfCoachingProgramPage(driver);
        treatmentVideosPage = new TreatmentVideosPage(driver);
        header = new Header(driver);
        signUpPage = new SignUpPage(driver);
        treatmentReviewsPage = new TreatmentReviewsPage(driver);
        specificTreatmentReviewsPage = new SpecificTreatmentReviewsPage(driver);
        specificTreatmentVideosPage = new SpecificTreatmentVideosPage(driver);
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

        //go to Single Review page from Home page
        homePage.goToSingleReviewPage();

        //check that div block with review exists and displayed
        Assert.assertTrue(singleReviewPage.isOnPage());

    }

    //Navigation to About page from Home page
    @Test
    public void checkFooterLinkAbout(){

        //go to About page from Footer
        footer.goToAboutUsPage();

        //check that About US body are not empty
        Assert.assertTrue(!aboutUsPage.bodyIsEmpty());

        //check that About Us page has paragraphs
        Assert.assertTrue(aboutUsPage.amountOfParagraphs());

        //check URL
        Assert.assertTrue(aboutUsPage.checkUrl());

    }

    //Navigation to FAQ page from Home page
    @Test
    public void checkFooterLinkFAQ(){

        //go to FAQ page
        footer.goToFAQPage();

        //check that FAQ body are not empty
        Assert.assertTrue(!faqPage.bodyIsEmpty());

        //check that FAQ page has paragraphs
        Assert.assertTrue(faqPage.amountOfQustions());

        //check URL
        Assert.assertTrue(faqPage.checkUrl());
    }

    //Navigation to Blog page from Home page
    @Test
    public void checkFooterLinkBlog(){

        //go to Blog page
        footer.goToBlogPage();

        //check that blogs are on that page
        Assert.assertTrue(!blogPage.bodyIsEmpty());

        //check that blogs are more than 0
        Assert.assertTrue(blogPage.checkAmountOfBlogs());

        //check URL
        Assert.assertTrue(blogPage.checkUrl());
    }

    //Navigation to Resources page from Home page
    @Test
    public void checkFooterLinkResources(){

        //go to Resources page
        footer.goToResourcesPage();

        //check that resources are on that page
        Assert.assertTrue(!resourcesPage.bodyIsEmpty());

        //check that resources more than 0
        Assert.assertTrue(resourcesPage.checkAmountOfResources());

        //check URL
        Assert.assertTrue(resourcesPage.checkUrl());
    }

    //Navigation to Testimonials page from Home page
    @Test
    public void checkFooterLinkTestimonials(){

        //go to Testimonials page
        footer.goToTestimonialsPage();

        //check that cards are on that page
        Assert.assertTrue(!testimonialsPage.bodyIsEmpty());

        //check the same in another way
        Assert.assertTrue(testimonialsPage.checkAmountOfCards());

        //check URL
        Assert.assertTrue(testimonialsPage.checkUrl());
    }

    //Navigation to Contact Us page from Home page
    @Test
    public void checkFooterLinkContactUs(){

        //go to Contact Us
        footer.goToContactUsPage();

        //check that Contact Form on the page
        Assert.assertTrue(contactUsPage.bodyIsEmpty());

        //check that all items are on page
        Assert.assertTrue(contactUsPage.checkAmountOfItems());

        //check URL
        Assert.assertTrue(contactUsPage.checkUrl());

    }

    //Navigation to Privacy Policy page from Home page
    @Test
    public void checkFooterCopyrightPrivacyPolicy(){

        //go to Privacy Policy page
        footer.goToPrivacyPolicyPage();

        //check that page has text
        Assert.assertTrue(privacyPolicyPage.checkAmountOfParagraphs());

        //check URL
        Assert.assertTrue(privacyPolicyPage.checkUrl());

    }

    //Navigation to Terms of Service page from Home page
    @Test
    public void checkFooterCopyrightTermsOfService(){

        //go to Terms of Service page
        footer.goToTermsOfServicePage();

        //check that page has text
        Assert.assertTrue(termsOfServicePage.checkAmountOfParagraphs());

        //check URL
        Assert.assertTrue(termsOfServicePage.checkUrl());

    }

    //Navigation to Treatment Ratings Condition page from Home page
    @Test
    public void goToTreatmentRatingsConditionPage(){

        //get Featured Condition url and set it as expected url
        String expectedUrl = homePage.getFeaturedConditionUrl();

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage();

        //check URL
        Assert.assertEquals(expectedUrl, treatmentRatingsConditionPage.getCurrentUrl());
    }

    //Navigation to Condition Selection page from Home page
    @Test
    public void goToConditionSelectionPage() {

        //find and save expected URL
        String expectedURL  = homePage.getGetStartedButtonUrl();

        //go to Condition Selection page
        homePage.goToConditionSelectionPage();

        //check URL
        Assert.assertEquals(expectedURL, conditionSelectionPage.getCurrentUrl());

    }

    //Navigation to Treatment Ratings Condition page from the Condition Selection page
    @Test
    public void goToTreatmentRatingsConditionPageFromConditionSelectionPage() {

        //create local variables
        String previousURL;
        String currentURL;

        //go to Condition Selection page
        homePage.goToConditionSelectionPage();

        //save current URL
        previousURL = conditionSelectionPage.getCurrentUrl();

        //go to Treatment Ratings Condition page
        conditionSelectionPage.goToTreatmentRatingsConditionPage(ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"));

        //save current URL
        currentURL = treatmentRatingsConditionPage.getCurrentUrl();

        //check that previous and current URLs are not equals
        assertNotEquals(previousURL, currentURL);

    }

    //Navigation to Condition Selection page from the Treatment Ratings Condition page
    @Test
    public void goToConditionSelectionPageFromTreatmentRatingsConditionPage() {

        //create local variables
        String previousURL;
        String currentURL;

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage();

        //save current URL
        previousURL = treatmentRatingsConditionPage.getCurrentUrl();

        //go to Condition Selection page
        treatmentRatingsConditionPage.goToConditionSelectionPage();

        //save current URL
        currentURL = conditionSelectionPage.getCurrentUrl();

        //check that previous and current URLs are not equals
        assertNotEquals(previousURL, currentURL);
    }

    //Navigation to Facebook page from Footer
    @Test
    public void goToFacebookPageFromFooter(){

        //go to Facebook
        footer.goToFacebookPage();

        //check URL
        Assert.assertTrue(facebookPage.checkUrl());

    }

    //Navigation to Twitter page from Footer
    @Test
    public void goToTwitterPageFromFooter(){

        //go to Twitter
        footer.goToTwitterPage();

        //check URL
        Assert.assertTrue(twitterPage.checkUrl());

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
                .goToWriteAReviewPage(); //go to Write a Review page

        //verify that we are at the right page
        Assert.assertTrue(writeAReviewPage.checkUrl());

    }

    //Navigation to Write a Review page from Detailed Blog page
    @Test
    public void goToWriteAReviewPageFromDetailedBlogPage(){


        footer.goToBlogPage()                           //go to Blog page
                .goToDetailedBlogPage(1)    //go to Detailed Blog page
                .goToWriteAReviewPage();                //go to Write a Review page

        //verify that we are at the right page
        Assert.assertTrue(writeAReviewPage.checkUrl());

    }

    //Navigation to 1st step of Coaching Program Write Coaching Request page from Treatment Ratings Condition page
    @Test
    public void goToFirstStepOfCoachingProgramFromTreatmentRatingsConditionPage(){

        homePage.goToTreatmentRatingsConditionPage()    //go to Treatment Ratings Condition page
                .goToFirstStepOfCoachingProgramPage();  //go to 1st step of Coaching Program Write Coaching Request page

        //check URL
        Assert.assertTrue(firstStepOfCoachingProgramPage.checkUrl());

    }

    //Navigation to Videos&Guides Condition page from Treatment Ratings Condition page
    @Test
    public void goToVideosAndGuidesConditionPageFromTreatmentRatingsConditionPage(){

        //create local variable
        String expectedURL;

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage();

        //save expected url
        expectedURL =  treatmentRatingsConditionPage.getCurrentUrl() + "-videos";

        //go to Videos&Guides Condition page
        treatmentRatingsConditionPage.goToTreatmentVideosPage();

        //check URL
        Assert.assertEquals(expectedURL, treatmentVideosPage.getCurrentUrl());

    }

    //Navigation to Sign Up page from Videos&Guides Condition page
    @Test
    public void goToSignUpPageFromVideosAndGuidesConditionPage(){

        homePage.goToTreatmentRatingsConditionPage()    //go to Treatment Ratings Condition page
                .goToTreatmentVideosPage();             //go to Treatment Videos&Guides page

        //go to Sign Up page
        header.goToSignUpPage();

        //check URL
        Assert.assertTrue(signUpPage.checkUrl());

        //check that Join Now button exists
        Assert.assertTrue(signUpPage.checkJoinNowButtonExists());

        //check that Sign up with Facebook button exists
        Assert.assertTrue(signUpPage.checkSignUpWithFacebookButtonExists());

    }

    //Navigation to Write a Review page from Treatment Ratings Condition page
    @Test
    public void goToWriteAReviewPageFromTreatmentRatingsConditionPage(){

        homePage.goToConditionSelectionPage()   //go to Condition Selection page
                .goToTreatmentRatingsConditionPage( ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name")) //go to Treatment Ratings Condition page
                .goToWriteAReviewPage();        //go to Write a Review page

        //check URL
        Assert.assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Ratings Condition", "url"), writeAReviewPage.getCurrentUrl());

    }

    //Navigation to Treatment Reviews page from Treatment Ratings Condition page
    @Test
    public void goToTreatmentReviewsPageFromTreatmentRatingsConditionPage(){

        //create local variable
        String expectedURL;

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage();

        //save expected url
        expectedURL =  treatmentRatingsConditionPage.getCurrentUrl() + "-reviews";

        //go to Treatment Reviews page (click on Treatment Reviews tab)
        treatmentRatingsConditionPage.goToTreatmentReviewsPage();

        //check URL
        Assert.assertEquals(expectedURL, treatmentReviewsPage.getCurrentUrl());

    }

    //Navigation to Write a Review page from Treatment Reviews page
    @Test
    public void goToWriteAReviewPageFromTreatmentReviewsPage(){

        homePage.goToTreatmentRatingsConditionPage()    //go to Treatment Ratings Condition page
                .goToTreatmentReviewsPage()             //go to Treatment Reviews page (click on Treatment Reviews tab)
                .goToWriteAReviewPage();                //go to Write a Review page (click on "Share your Experience" button)

        //check URL
        Assert.assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Reviews", "url"), writeAReviewPage.getCurrentUrl());

        //check group title
        Assert.assertEquals("What is your gender?", writeAReviewPage.getGroupTitle());

    }

    //Navigation to Specific Videos&Guides Treatment page from Treatment Rating -> Specific Treatment Review page
    @Test
    public void goToSpecificVideosAndGuidesPageFromSpecificTreatmentReviewPage(){

        //create local variable
        String expectedURL;

        homePage.goToTreatmentRatingsConditionPage()               //go to Treatment Ratings Condition page
                .goToSpecificTreatment("Massage");  //go to Specific Treatment Review page

        //save expected url
        expectedURL = specificTreatmentReviewsPage.getCurrentUrl() + "-recommendations";

        //go to Specific Videos&Guides Treatment page
        specificTreatmentReviewsPage.goToSpecificTreatmentVideosPage();

        //check URL
        Assert.assertEquals(expectedURL, specificTreatmentVideosPage.getCurrentUrl());

    }

}
