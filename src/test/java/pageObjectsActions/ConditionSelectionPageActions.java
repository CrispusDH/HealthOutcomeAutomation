package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjectsElements.ConditionSelectionPageElements;

/**
 * Created by Crispus on 28.12.2016.
 */
public class ConditionSelectionPageActions {

    public static void goToTreatmentRatingsConditionPage(WebDriver driver, String BodyAreaName, String ConditionName){

        Actions builder = new Actions(driver);
        ConditionSelectionPageElements.li_InjuryBodyArea(driver, BodyAreaName).click();
        builder.moveToElement(ConditionSelectionPageElements.li_ConditionElement(driver, ConditionName)).click();
        builder.build().perform();

    }

}
