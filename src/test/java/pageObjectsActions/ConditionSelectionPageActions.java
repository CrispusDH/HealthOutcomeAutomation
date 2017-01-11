package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsElements.ConditionSelectionPageElements;

import java.util.concurrent.TimeUnit;

public class ConditionSelectionPageActions {

    public static void goToTreatmentRatingsConditionPage(WebDriver driver, String BodyAreaName, String ConditionName){

        Actions builder = new Actions(driver);
        ConditionSelectionPageElements.li_InjuryBodyArea(driver, BodyAreaName).click();
        builder.moveToElement(ConditionSelectionPageElements.li_ConditionElement(driver, ConditionName)).click();
        builder.build().perform();

    }

}
