package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.TreatmentRatingsConditionPageElements;
import pageObjectsElements.TreatmentReviewsPageElements;

public class TreatmentReviewsPageActions {

    //go to Write a Review page
    public static void clickOnShareYourExperienceButton(WebDriver driver){

        TreatmentReviewsPageElements.button_ShareYourExperience(driver).click();

    }

    //click on Tab
    public static void clickOnTab(WebDriver driver, String tabNames){

        switch (tabNames) {

            case "Treatment Ratings":
                TreatmentReviewsPageElements.tab(driver, "TREATMENT RATINGS").click();
                break;

            case "Treatment Reviews":
                TreatmentReviewsPageElements.tab(driver, "TREATMENT REVIEWS").click();
                break;

            case "Videos & Guides":
                TreatmentReviewsPageElements.tab(driver, "VIDEOS & GUIDES").click();
                break;
        }

    }

}
