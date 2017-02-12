package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.SpecificTreatmentReviewsPageElements;
import pageObjectsElements.TreatmentRatingsConditionPageElements;

public class SpecificTreatmentReviewsPageActions {

    //click on Tab
    public static void clickOnTab(WebDriver driver, String tabNames){

        switch (tabNames) {

            case "Treatment Reviews":
                TreatmentRatingsConditionPageElements.tab(driver, "TREATMENT REVIEWS").click();
                break;

            case "Videos & Guides":
                TreatmentRatingsConditionPageElements.tab(driver, "VIDEOS & GUIDES").click();
                break;
        }

    }

    //go to Write a Review page
    public static void clickOnShareYourExperienceButton(WebDriver driver){

        SpecificTreatmentReviewsPageElements.button_ShareYourExperience(driver).click();

    }

}
