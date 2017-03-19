package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import static utility.WaitConditionForWebElements.allPresence;

public class TreatmentRatingsConditionPage extends BaseClass {

    static String expectedVideosURL;
    static String expectedReviewsURL;

    //<editor-fold desc="Finding page Elements">

    private By link_ChangeConditionLocator = By.cssSelector(".change-condition");
    private By button_LearnMoreLocator = By.cssSelector(".button-cta span");
    private By button_ShareYourExperienceLocator = By.cssSelector(".banner-cta .button-cta span");
    private By tabLocator = By.cssSelector(".hero-tabs li");
    private By li_TreatmentLocator = By.cssSelector(".treatment-link");

    //Learn More button
    private WebElement button_LearnMore(){

        return findElementByText(waitForElements(button_LearnMoreLocator, allPresence), "LEARN MORE   ");

    }

    //Share your experience button
    private WebElement button_ShareYourExperience(){

        return findElementByText(waitForElements(button_ShareYourExperienceLocator, allPresence), "SHARE YOUR EXPERIENCE");

    }

    //Find tab
    private WebElement tab(String sTabName){

        return findElementByText(waitForElements(tabLocator, allPresence), sTabName);

    }

    //find specific Treatment
    private WebElement li_Treatment(String sTreatmentName){

        return findElementByText(waitForElements(li_TreatmentLocator, allPresence), sTreatmentName);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

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

    //click on Specific tab
    private BaseClass clickOnSpecificTab(String sTabNames){

        switch (sTabNames) {

            case "Treatment Ratings":
                click(tab("TREATMENT RATINGS"));
                return new TreatmentRatingsConditionPage();

            case "Treatment Reviews":
                click(tab("TREATMENT REVIEWS"));
                return new TreatmentReviewsPage();

            case "Videos & Guides":
                click(tab("VIDEOS & GUIDES"));
                return new TreatmentVideosPage();
        }

        return null;

    }

    //click on Specific Treatment block
    private SpecificTreatmentReviewsPage clickOnSpecificTreatment(String sTreatmentName){

        click(li_Treatment(sTreatmentName));

        return new SpecificTreatmentReviewsPage();

    }


    //</editor-fold>

    //<editor-fold desc="Public methods">

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

        return (TreatmentRatingsConditionPage) clickOnSpecificTab("Treatment Ratings");

    }

    //go to Treatment Reviews page
    public TreatmentReviewsPage goToTreatmentReviewsPage(){

        return (TreatmentReviewsPage) clickOnSpecificTab("Treatment Reviews");

    }

    //go to Treatment Videos & Guides page
    public TreatmentVideosPage goToTreatmentVideosPage(){

        return (TreatmentVideosPage) clickOnSpecificTab("Videos & Guides");

    }


    //check url
    public TreatmentRatingsConditionPage checkURL (String sExpectedUrl){

        Assert.assertEquals(sExpectedUrl, getURL());

        return this;

    }

    //</editor-fold>

}
