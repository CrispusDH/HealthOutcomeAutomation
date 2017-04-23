package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import static enums.ConditionTabsEnum.TREATMENT_RATINGS;
import static enums.ConditionTabsEnum.TREATMENT_REVIEWS;
import static enums.ConditionTabsEnum.VIDEOS_AND_GUIDES;
import static waiters.WaitConditionForUrl.urlToBe;
import static waiters.WaitConditions.allPresence;
import static waiters.WaitConditions.allPresenceExtended;

public class TreatmentRatingsConditionPage extends BasePage {

    static String expectedVideosURL;
    static String expectedReviewsURL;

    private By link_ChangeConditionLocator = By.cssSelector(".change-condition");
    private By button_LearnMoreLocator = By.cssSelector(".button-cta span");
    private By button_ShareYourExperienceLocator = By.cssSelector(".banner-cta .button-cta span");
    private By tabLocator = By.cssSelector(".hero-tabs li");
    private By li_TreatmentLocator = By.cssSelector(".treatment-link");

    //Learn More button
    private WebElement button_LearnMore(){
        return findElementByText(waitForElements(button_LearnMoreLocator, allPresenceExtended), "LEARN MORE   ");
    }

    //Share your experience button
    private WebElement button_ShareYourExperience(){
        return findElementByText(waitForElements(button_ShareYourExperienceLocator, allPresence), "SHARE YOUR EXPERIENCE");
    }

    //find specific Treatment
    private WebElement li_Treatment(String sTreatmentName){
        return findElementByText(waitForElements(li_TreatmentLocator, allPresence), sTreatmentName);
    }

    //click on Change Condition link
    private ConditionSelectionPage clickOnChangeConditionLink(){
        click(link_ChangeConditionLocator);
        return new ConditionSelectionPage();
    }

    //click on Lear More button
    private FirstStepOfCoachingProgramPage clickOnLearnMoreButton(){
        click(button_LearnMore());
        return new FirstStepOfCoachingProgramPage();
    }

    //click on Share Your Experience button
    private WriteAReviewPage clickOnShareYourExperienceButton(){
        click(button_ShareYourExperience());
        return new WriteAReviewPage();
    }

    //click on Specific Treatment block
    private SpecificTreatmentReviewsPage clickOnSpecificTreatment(String sTreatmentName){
        click(li_Treatment(sTreatmentName));
        return new SpecificTreatmentReviewsPage();
    }

    //get temporary expected Videos URL
    public TreatmentRatingsConditionPage setExpectedVideosURL(){
        expectedVideosURL = getURL() + "-videos";
        return this;
    }

    //get temporary expected Reviews URL
    public TreatmentRatingsConditionPage setExpectedReviewsURL(){
        expectedReviewsURL = getURL() + "-reviews";
        return this;
    }

    //go to Condition Selection page
    public ConditionSelectionPage goToConditionSelectionPage(){
        return clickOnChangeConditionLink();
    }

    //go to 1st step of coaching program
    public FirstStepOfCoachingProgramPage goToFirstStepOfCoachingProgramPage(){
        return clickOnLearnMoreButton();
    }

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){
        return clickOnShareYourExperienceButton();
    }

    //go into Specific Treatment
    public SpecificTreatmentReviewsPage goToSpecificTreatment(String sTreatmentName){
        return clickOnSpecificTreatment(sTreatmentName);
    }

    //go to Treatment Ratings Condition page
    public TreatmentRatingsConditionPage goToTreatmentRatingsConditionPage(){
        return clickOnSpecificTab(TREATMENT_RATINGS, tabLocator);
    }

    //go to Treatment Reviews page
    public TreatmentReviewsPage goToTreatmentReviewsPage(){
        return clickOnSpecificTab(TREATMENT_REVIEWS, tabLocator);
    }

    //go to Treatment Videos & Guides page
    public TreatmentVideosPage goToTreatmentVideosPage(){
        return clickOnSpecificTab(VIDEOS_AND_GUIDES, tabLocator);
    }

    //check url
    public TreatmentRatingsConditionPage checkURL (String sExpectedUrl){
        checkUrlToBe(sExpectedUrl, urlToBe);
        return this;
    }

}