package pages;

import enums.ConditionTabsEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;

import static enums.ConditionTabsEnum.TREATMENT_REVIEWS;
import static enums.ConditionTabsEnum.VIDEOS_AND_GUIDES;
import static utility.WaitConditions.allPresence;

public class SpecificTreatmentReviewsPage extends BasePage {

    static String expectedSpecificTreatmentVideosPageURL;

    private By button_ShareYourExperienceLocator = By.cssSelector(".banner-cta .button-cta span");
    private By tabLocator = By.cssSelector(".hero-tabs li");

    //Share your experience button
    private WebElement button_ShareYourExperience(){
        return findElementByText(waitForElements(button_ShareYourExperienceLocator, allPresence), "SHARE YOUR EXPERIENCE");
    }

    //click on Share your experience button
    private WriteAReviewPage clickOnShareYourButton(){
        click(button_ShareYourExperience());
        return new WriteAReviewPage();
    }

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){
        return clickOnShareYourButton();
    }

    //go to Treatment Review tab in Specific Treatment
    public SpecificTreatmentReviewsPage goToSpecificTreatmentReviewPage(){
        return clickOnSpecificTab(TREATMENT_REVIEWS, tabLocator);
    }

    //go to Treatment Videos & Guides tab in Specific Treatment
    public SpecificTreatmentVideosPage goToSpecificTreatmentVideosPage(){
        return clickOnSpecificTab(VIDEOS_AND_GUIDES, tabLocator);
    }

    //get temporary expected specific Treatment Videos page URL
    public SpecificTreatmentReviewsPage setExpectedSpecificTreatmentVideosPageURL(){
        expectedSpecificTreatmentVideosPageURL = getURL() + "-recommendations";
        return this;
    }

}