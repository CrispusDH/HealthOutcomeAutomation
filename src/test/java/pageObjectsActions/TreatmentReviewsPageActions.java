package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.TreatmentRatingsConditionPageElements;
import pageObjectsElements.TreatmentReviewsPageElements;

public class TreatmentReviewsPageActions {

    //go to Write a Review page
    public static void clickOnShareYourExperienceButton(WebDriver driver){

        TreatmentReviewsPageElements.button_ShareYourExperience(driver).click();

    }

}
