package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import static utility.WaitConditionForWebElements.allPresence;

public class TreatmentReviewsPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By button_ShareYourExperienceLocator = By.cssSelector(".banner-cta .button-cta span");
    private By tabLocator = By.cssSelector(".hero-tabs li");

    //Share your experience button
    private WebElement button_ShareYourExperience(){

        return findElementByText(waitForElements(button_ShareYourExperienceLocator, allPresence), "SHARE YOUR EXPERIENCE");

    }

    //Find tab
    private WebElement tab(String sTabName){

        return findElementByText(waitForElements(tabLocator, allPresence), sTabName);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

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

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){

        return clickOnShareYourExperienceButton();

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

    //check URL
    public TreatmentReviewsPage checkURL(){

        Assert.assertEquals(TreatmentRatingsConditionPage.expectedReviewsURL, getURL());

        return this;

    }

    //</editor-fold>

}
