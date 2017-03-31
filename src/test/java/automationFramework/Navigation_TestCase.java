package automationFramework;

import PageObject.*;
import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.ReadXMLFile;
import utility.RetryRule;
import utility.WebDriverProvider;

@RunWith(JUnit4.class)
public class Navigation_TestCase extends WebDriverProvider{

    //<editor-fold desc="Initialisation block">

    private HomePage homePage;
    private Footer footer;

    //</editor-fold>

    //<editor-fold desc="BeforeClass, AfterClass, Before, After annotations">


    @Before
    public void createNewDriver() {

        this.setupDriver();

        getDriver().get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));

        homePage = new HomePage();
        footer = new Footer();

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

    //Navigation to Single Review page from Home page
    @Test
    public void goToSingleReviewPage(){

        homePage.goToSingleReviewPage()
                .isReviewInfoOnPage();

    }

    //Navigation to About page from Home page
    @Test
    public void checkFooterLinkAbout(){

        //go to About page from Footer
        footer.goToAboutUsPage()
                .checkIsEmpty()
                .checkAmountOfParagraphs()
                .checkUrl();

    }

    //Navigation to FAQ page from Home page
    @Test
    public void checkFooterLinkFAQ(){

        //go to FAQ page
        footer.goToFAQPage()
                .checkIsBodyEmpty()
                .checkAmountOfQustions()
                .checkUrl();

    }

    //Navigation to Blog page from Home page
    @Test
    public void checkFooterLinkBlog(){

        //go to Blog page
        footer.goToBlogPage()
                .checkIsBodyEmpty()
                .checkAmountOfBlogs()   //check that blogs are more than 0
                .checkUrl();

    }

    //Navigation to Resources page from Home page
    @Test
    public void checkFooterLinkResources(){

        //go to Resources page
        footer.goToResourcesPage()
                .checkIsBodyEmpty()
                .checkAmountOfResources()   //check that resources more than 0
                .checkUrl();

    }

    //Navigation to Testimonials page from Home page
    @Test
    public void checkFooterLinkTestimonials(){

        //go to Testimonials page
        footer.goToTestimonialsPage()
                .checkIsBodyEmpty()
                .checkAmountOfCards()
                .checkUrl();

    }

    //Navigation to Contact Us page from Home page
    @Test
    public void checkFooterLinkContactUs(){

        //go to Contact Us
        footer.goToContactUsPage()
                .checkIsBodyEmpty()
                .checkAmountOfItems()
                .checkUrl();

    }

    //Navigation to Privacy Policy page from Home page
    @Test
    public void checkFooterCopyrightPrivacyPolicy(){

        //go to Privacy Policy page
        footer.goToPrivacyPolicyPage()
                .checkAmountOfParagraphs()
                .checkUrl();

    }

    //Navigation to Terms of Service page from Home page
    @Test
    public void checkFooterCopyrightTermsOfService(){

        //go to Terms of Service page
        footer.goToTermsOfServicePage()
                .checkAmountOfParagraphs()
                .checkUrl();

    }

    //Navigation to Treatment Ratings Condition page from Home page
    @Test
    public void goToTreatmentRatingsConditionPage(){

        //get Featured Condition url and set it as expected url
        String expectedUrl = homePage.getFeaturedConditionUrl();

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage()
                .checkURL(expectedUrl);

    }

    //Navigation to Condition Selection page from Home page
    @Test
    public void goToConditionSelectionPage() {

        //find and save expected URL
        String expectedURL  = homePage.getGetStartedButtonUrl();

        //go to Condition Selection page
        homePage.goToConditionSelectionPage()
                .checkURL(expectedURL);

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
                .goToConditionSelectionPage();

    }

    //Navigation to Facebook page from Footer
    @Test
    public void goToFacebookPageFromFooter(){

        //go to Facebook
        footer.goToFacebookPage()
                .checkUrl();

    }

    //Navigation to Twitter page from Footer
    @Test
    public void goToTwitterPageFromFooter(){

        //go to Twitter
        footer.goToTwitterPage()
                .checkUrl();

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


        footer.goToBlogPage()
                .goToWriteAReviewPage()
                .checkURLBasic();

    }

    //Navigation to Write a Review page from Detailed Blog page
    @Test
    public void goToWriteAReviewPageFromDetailedBlogPage(){


        footer.goToBlogPage()
                .goToDetailedBlogPage(1)    //go to Detailed Blog page
                .goToWriteAReviewPage()
                .checkURLBasic();

    }

    //Navigation to 1st step of Coaching Program Write Coaching Request page from Treatment Ratings Condition page
    @Test
    public void goToFirstStepOfCoachingProgramFromTreatmentRatingsConditionPage(){

        homePage.goToTreatmentRatingsConditionPage()
                .goToFirstStepOfCoachingProgramPage()
                .checkUrl();

    }

    //Navigation to Videos&Guides Condition page from Treatment Ratings Condition page
    @Test
    public void goToVideosAndGuidesConditionPageFromTreatmentRatingsConditionPage(){

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage()
                .setExpectedVideosURL() //set expected url to static variable
                .goToTreatmentVideosPage()
                .checkURL();

    }

    //Navigation to Sign Up page from Videos&Guides Condition page
    @Test
    public void goToSignUpPageFromVideosAndGuidesConditionPage(){

        homePage.goToTreatmentRatingsConditionPage()
                .goToTreatmentVideosPage()
                .getHeader()
                .goToSignUpPage()
                .checkUrl()
                .checkIsJoinNowButtonExists()
                .checkIsSignUpWithFacebookButtonExists();

    }

    //Navigation to Write a Review page from Treatment Ratings Condition page
    @Test
    public void goToWriteAReviewPageFromTreatmentRatingsConditionPage(){

        homePage.goToConditionSelectionPage()
                .goToTreatmentRatingsConditionPage( ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name")) //go to Treatment Ratings Condition page
                .goToWriteAReviewPage()
                .checkURLFromTreatmentRatingsCondition();

    }

    //Navigation to Treatment Reviews page from Treatment Ratings Condition page
    @Test
    public void goToTreatmentReviewsPageFromTreatmentRatingsConditionPage(){

        //go to Treatment Ratings Condition page
        homePage.goToTreatmentRatingsConditionPage()
                .setExpectedReviewsURL()    //save expected url
                .goToTreatmentReviewsPage()
                .checkURL();

    }

    //Navigation to Write a Review page from Treatment Reviews page
    @Test
    public void goToWriteAReviewPageFromTreatmentReviewsPage(){

        homePage.goToTreatmentRatingsConditionPage()
                .goToTreatmentReviewsPage()
                .goToWriteAReviewPage()
                .checkURLFromTreatmentsReviews()
                .checkGroupTitleInCaseOfFromTreatmentReviewsPage();

    }

    //Navigation to Specific Videos&Guides Treatment page from Treatment Rating -> Specific Treatment Review page
    @Test
    public void goToSpecificVideosAndGuidesPageFromSpecificTreatmentReviewPage(){

        homePage.goToTreatmentRatingsConditionPage()
                .goToSpecificTreatment("Massage")
                .setExpectedSpecificTreatmentVideosPageURL()
                .goToSpecificTreatmentVideosPage()
                .checkURL();

    }

}
