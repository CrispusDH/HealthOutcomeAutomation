package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.WriteAReviewPageElements;
import utility.Constant;

public class WriteAReviewPageActions {
    public static void fillAndPostReview(WebDriver driver, String BodyAreaName, String ConditionName, String TreatmentName, String RateChoiceName){
        WriteAReviewPageElements.li_InjuryBodyArea(driver, BodyAreaName).click();
        WriteAReviewPageElements.li_ConditionElement(driver, ConditionName).click();
        WriteAReviewPageElements.li_TreatmentsElement(driver, TreatmentName).click();
        WriteAReviewPageElements.li_RateYourTreatmentsFirstElement(driver, RateChoiceName).click();
        WriteAReviewPageElements.bttn_PostReview(driver).submit();
    }

}
