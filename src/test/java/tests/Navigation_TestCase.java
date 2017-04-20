package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.ReadXMLFile;
import utility.BaseTest;

@RunWith(JUnit4.class)
public class Navigation_TestCase extends BaseTest {

    //Navigation to Single Review page from Home page
    @Test
    public void goToSingleReviewPage(){

        openHomePage()
                .goToSingleReviewPage()
                .isReviewInfoOnPage();

    }

    //Navigation to About page from Home page
    @Test
    public void checkFooterLinkAbout(){

        //go to About page from Footer
        openHomePage()
                .getFooter()
                .goToAboutUsPage()
                .checkIsEmpty()
                .checkAmountOfParagraphs()
                .checkUrl();

    }

    //Navigation to FAQ page from Home page
    @Test
    public void checkFooterLinkFAQ(){

        //go to FAQ page
        openHomePage()
                .getFooter()
                .goToFAQPage()
                .checkIsBodyEmpty()
                .checkAmountOfQustions()
                .checkUrl();

    }

    //Navigation to Blog page from Home page
    @Test
    public void checkFooterLinkBlog(){

        //go to Blog page
        openHomePage()
                .getFooter()
                .goToBlogPage()
                .checkIsBodyEmpty()
                .checkAmountOfBlogs()   //check that blogs are more than 0
                .checkUrl();

    }

    //Navigation to Resources page from Home page
    @Test
    public void checkFooterLinkResources(){

        //go to Resources page
        openHomePage()
                .getFooter()
                .goToResourcesPage()
                .checkIsBodyEmpty()
                .checkAmountOfResources()   //check that resources more than 0
                .checkUrl();

    }

    //Navigation to Testimonials page from Home page
    @Test
    public void checkFooterLinkTestimonials(){

        //go to Testimonials page
        openHomePage()
                .getFooter()
                .goToTestimonialsPage()
                .checkIsBodyEmpty()
                .checkAmountOfCards()
                .checkUrl();

    }

    //Navigation to Contact Us page from Home page
    @Test
    public void checkFooterLinkContactUs(){

        //go to Contact Us
        openHomePage()
                .getFooter()
                .goToContactUsPage()
                .checkIsBodyEmpty()
                .checkAmountOfItems()
                .checkUrl();

    }

    //Navigation to Privacy Policy page from Home page
    @Test
    public void checkFooterCopyrightPrivacyPolicy(){

        //go to Privacy Policy page
        openHomePage()
                .getFooter()
                .goToPrivacyPolicyPage()
                .checkAmountOfParagraphs()
                .checkUrl();

    }

    //Navigation to Terms of Service page from Home page
    @Test
    public void checkFooterCopyrightTermsOfService(){

        //go to Terms of Service page
        openHomePage()
                .getFooter()
                .goToTermsOfServicePage()
                .checkAmountOfParagraphs()
                .checkUrl();
    }
/*
    //Navigation to Treatment Ratings Condition page from Home page
    @Test
    public void goToTreatmentRatingsConditionPage(){

        //get Featured Condition url and set it as expected url
        String expectedUrl = .getFeaturedConditionUrl();

        //go to Treatment Ratings Condition page
        openHomePage().goToTreatmentRatingsConditionPage()
                .checkURL(expectedUrl);

    }

    //Navigation to Condition Selection page from Home page
    @Test
    public void goToConditionSelectionPage() {

        //find and save expected URL
        String expectedURL  = homePage.getGetStartedButtonUrl();

        //go to Condition Selection page
        openHomePage().goToConditionSelectionPage()
                .checkURL(expectedURL);

    }
*/
    //Navigation to Treatment Ratings Condition page from the Condition Selection page
    @Test
    public void goToTreatmentRatingsConditionPageFromConditionSelectionPage() {

        //go to Condition Selection page
        openHomePage()
                .goToConditionSelectionPage()
                .goToTreatmentRatingsConditionPage(ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name"));

    }

    //Navigation to Condition Selection page from the Treatment Ratings Condition page
    @Test
    public void goToConditionSelectionPageFromTreatmentRatingsConditionPage() {

        //go to Treatment Ratings Condition page
        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .goToConditionSelectionPage();

    }

    //Navigation to Facebook page from Footer
    @Test
    public void goToFacebookPageFromFooter(){

        //go to Facebook
        openHomePage()
                .getFooter()
                .goToFacebookPage()
                .checkUrl();

    }

    //Navigation to Twitter page from Footer
    @Test
    public void goToTwitterPageFromFooter(){

        //go to Twitter
        openHomePage()
                .getFooter()
                .goToTwitterPage()
                .checkUrl();

    }

    //Check Linkedin href from Footer
    @Test
    public void checkLinkedinUrl(){

        Assert.assertTrue(openHomePage().getFooter().checkLinkedingUrl());

    }

    //Check mail href service from Footer
    @Test
    public void goToMailServiceFromFooter(){

        Assert.assertTrue(openHomePage().getFooter().checkMailUrl());

    }

    //Navigation to Write a Review page from Blog page
    @Test
    public void goToWriteAReviewPageFromBlogPage(){


        openHomePage()
                .getFooter()
                .goToBlogPage()
                .goToWriteAReviewPage()
                .checkURLFromBlogPage();

    }

    //Navigation to Write a Review page from Detailed Blog page
    @Test
    public void goToWriteAReviewPageFromDetailedBlogPage(){

        openHomePage()
                .getFooter()
                .goToBlogPage()
                .goToDetailedBlogPage(1)    //go to Detailed Blog page
                .goToWriteAReviewPage()
                .checkURLFromDetailedBlogPage();

    }

    //Navigation to 1st step of Coaching Program Write Coaching Request page from Treatment Ratings Condition page
    @Test
    public void goToFirstStepOfCoachingProgramFromTreatmentRatingsConditionPage(){

        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .goToFirstStepOfCoachingProgramPage()
                .checkUrl();

    }

    //Navigation to Videos&Guides Condition page from Treatment Ratings Condition page
    @Test
    public void goToVideosAndGuidesConditionPageFromTreatmentRatingsConditionPage(){

        //go to Treatment Ratings Condition page
        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .setExpectedVideosURL() //set expected url to static variable
                .goToTreatmentVideosPage()
                .checkURL();

    }

    //Navigation to Sign Up page from Videos&Guides Condition page
    @Test
    public void goToSignUpPageFromVideosAndGuidesConditionPage(){

        openHomePage()
                .goToTreatmentRatingsConditionPage()
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

        openHomePage()
                .goToConditionSelectionPage()
                .goToTreatmentRatingsConditionPage( ReadXMLFile.takeConstantFromXML("BodyArea", "Neck", "name"), ReadXMLFile.takeConstantFromXML("Condition", "Neck pain with radiculopathy", "name")) //go to Treatment Ratings Condition page
                .goToWriteAReviewPage()
                .checkURLFromTreatmentRatingsCondition();

    }

    //Navigation to Treatment Reviews page from Treatment Ratings Condition page
    @Test
    public void goToTreatmentReviewsPageFromTreatmentRatingsConditionPage(){

        //go to Treatment Ratings Condition page
        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .setExpectedReviewsURL()    //save expected url
                .goToTreatmentReviewsPage()
                .checkURL();

    }

    //Navigation to Write a Review page from Treatment Reviews page
    @Test
    public void goToWriteAReviewPageFromTreatmentReviewsPage(){

        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .goToTreatmentReviewsPage()
                .goToWriteAReviewPage()
                .checkURLFromTreatmentsReviews()
                .checkGroupTitleInCaseOfFromTreatmentReviewsPage();

    }

    //Navigation to Specific Videos&Guides Treatment page from Treatment Rating -> Specific Treatment Review page
    @Test
    public void goToSpecificVideosAndGuidesPageFromSpecificTreatmentReviewPage(){

        openHomePage()
                .goToTreatmentRatingsConditionPage()
                .goToSpecificTreatment("Massage")
                .setExpectedSpecificTreatmentVideosPageURL()
                .goToSpecificTreatmentVideosPage()
                .checkURL();

    }

}