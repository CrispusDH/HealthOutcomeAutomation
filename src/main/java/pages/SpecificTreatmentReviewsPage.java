package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;

import static utility.WaitConditions.allPresence;

public class SpecificTreatmentReviewsPage extends BasePage {

    static String expectedSpecificTreatmentVideosPageURL;

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

    //click on Share your experience button
    private WriteAReviewPage clickOnShareYourButton(){
        click(button_ShareYourExperience());
        return new WriteAReviewPage();
    }

    //click on specific tab
    private BasePage clickOnTab(String sTabName){
        switch (sTabName){
            case "Treatment Reviews":
                click(tab("TREATMENT REVIEWS"));
                return new SpecificTreatmentReviewsPage();
            case "Videos & Guides":
                click(tab("VIDEOS & GUIDES"));
                return new SpecificTreatmentVideosPage();
        }
        return null;
    }

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){
        return clickOnShareYourButton();
    }

    //go to Treatment Review tab in Specific Treatment
    public SpecificTreatmentReviewsPage goToSpecificTreatmentReviewPage(){
        return (SpecificTreatmentReviewsPage) clickOnTab("Treatment Reviews");
    }

    //go to Treatment Videos & Guides tab in Specific Treatment
    public SpecificTreatmentVideosPage goToSpecificTreatmentVideosPage(){
        return (SpecificTreatmentVideosPage) clickOnTab("Videos & Guides");
    }

    //get temporary expected specific Treatment Videos page URL
    public SpecificTreatmentReviewsPage setExpectedSpecificTreatmentVideosPageURL(){
        expectedSpecificTreatmentVideosPageURL = getURL() + "-recommendations";
        return this;
    }

}