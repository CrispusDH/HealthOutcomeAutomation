package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.TreatmentRatingsConditionPageElements;

public class TreatmentRatingsConditionPageActions {

    //go to Condition Selection page
    public static void goToConditionSelectionPage(WebDriver driver) {

        TreatmentRatingsConditionPageElements.link_ChangeCondition(driver).click();

    }

    //go to 1st step of coaching program
    public static void goToFirstStepOfCoachingProgram(WebDriver driver){

        TreatmentRatingsConditionPageElements.button_LearnMore(driver).click();

    }

    //click on Tab
    public static void clickOnTab(WebDriver driver, String tabNames){

        switch (tabNames) {

            case "Treatment Ratings":
                TreatmentRatingsConditionPageElements.tab(driver, "TREATMENT RATINGS").click();
                break;

            case "Treatment Reviews":
                TreatmentRatingsConditionPageElements.tab(driver, "TREATMENT REVIEWS").click();
                break;

            case "Videos & Guides":
                TreatmentRatingsConditionPageElements.tab(driver, "VIDEOS & GUIDES").click();
                break;
        }

    }

}
