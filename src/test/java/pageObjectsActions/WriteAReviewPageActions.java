package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.WriteAReviewPageElements;

public class WriteAReviewPageActions {

    //fill and post a review
    public static void fillAndPostReview(WebDriver driver, String BodyAreaName, String ConditionName, String TreatmentName, String RateChoiceName){

        //choose and click Body Area
        WriteAReviewPageElements.li_InjuryBodyArea(driver, BodyAreaName).click();

        //choose and click Condition name
        WriteAReviewPageElements.li_ConditionElement(driver, ConditionName).click();

        //choose and click Treatment
        WriteAReviewPageElements.li_TreatmentsElement(driver, TreatmentName).click();

        //choose and click rate
        WriteAReviewPageElements.li_RateYourTreatmentsFirstElement(driver, RateChoiceName).click();

        //click on Post review button
        WriteAReviewPageElements.button_PostReview(driver).submit();
    }

    //choose body area
    public static void chooseBodyArea(WebDriver driver, String BodyAreaName){

        WriteAReviewPageElements.li_InjuryBodyArea(driver, BodyAreaName).click();

    }

    //choose condition
    public static void chooseCondition(WebDriver driver, String ConditionName){

        WriteAReviewPageElements.li_ConditionElement(driver, ConditionName).click();

    }

}
