package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;

import static enums.ConditionTabsEnum.TREATMENT_RATINGS;
import static enums.ConditionTabsEnum.TREATMENT_REVIEWS;
import static enums.ConditionTabsEnum.VIDEOS_AND_GUIDES;
import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class TreatmentReviewsPage extends BasePage {

    private By button_ShareYourExperienceLocator = By.cssSelector(".banner-cta .button-cta span");
    private By tabLocator = By.cssSelector(".hero-tabs li");

    //Share your experience button
    private WebElement button_ShareYourExperience(){
        return findElementByText(waitForElements(button_ShareYourExperienceLocator, allPresence), "SHARE YOUR EXPERIENCE");
    }

    //click on Share Your Experience button
    private WriteAReviewPage clickOnShareYourExperienceButton(){
        click(button_ShareYourExperience());
        return new WriteAReviewPage();
    }

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){
        return clickOnShareYourExperienceButton();
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

    //check URL
    public TreatmentReviewsPage checkURL(){
        checkUrlToBe(TreatmentRatingsConditionPage.expectedReviewsURL, urlToBe);
        return this;
    }

}