package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsElements.ConditionSelectionPageElements;

import java.util.concurrent.TimeUnit;

public class ConditionSelectionPageActions {

    //go to Treatment Ratings Condition page
    public static void goToTreatmentRatingsConditionPage(WebDriver driver, String BodyAreaName, String ConditionName){

        //create new Action builder
        Actions builder = new Actions(driver);

        //choose Body area name and click on it block
        ConditionSelectionPageElements.li_InjuryBodyArea(driver, BodyAreaName).click();

        //scroll to element
        builder.moveToElement(ConditionSelectionPageElements.li_ConditionElement(driver, ConditionName)).click();

        //perform all actions
        builder.build().perform();

    }

}
