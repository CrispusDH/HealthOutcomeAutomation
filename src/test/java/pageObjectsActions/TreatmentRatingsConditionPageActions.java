package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.TreatmentRatingsConditionPageElements;

public class TreatmentRatingsConditionPageActions {

    public static void goToConditionSelectionPage(WebDriver driver) {

        TreatmentRatingsConditionPageElements.link_ChangeCondition(driver).click();

    }

}
