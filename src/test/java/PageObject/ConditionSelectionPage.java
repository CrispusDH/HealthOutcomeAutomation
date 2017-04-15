package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.concurrent.TimeUnit;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class ConditionSelectionPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By injuryBodyAreaLocator = By.cssSelector(".parts-list li > span");
    private By conditionElementLocator = By.cssSelector("#select-condition li a > span");
    private By forScrollingLocator = By.cssSelector(".select-step");

    //find all body areas
    private WebElement li_InjuryBodyArea(String bodyAreaName){

        return findElementByText(waitForElements(injuryBodyAreaLocator, allPresence), bodyAreaName);

    }

    //find all conditions
    private WebElement li_ConditionElement(String sConditionName){

        return findElementByText(waitForElements(conditionElementLocator, allPresence), sConditionName);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //choose Body area name and click on it block
    private ConditionSelectionPage chooseBodyAreaName(String sBodyAreaName){

        click(li_InjuryBodyArea(sBodyAreaName));



        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;

    }

    //choose Condition and click
    private TreatmentRatingsConditionPage clickOnSpecificConditionName(String conditionName){

        scrollUp();

        click(li_ConditionElement(conditionName));

        return new TreatmentRatingsConditionPage();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    public TreatmentRatingsConditionPage goToTreatmentRatingsConditionPage(String bodyAreaName, String conditionName){

        //choose Body area name and click on it block
        chooseBodyAreaName(bodyAreaName);

        //choose Condition and click
        return clickOnSpecificConditionName(conditionName);

    }

    //check URL
    public ConditionSelectionPage checkURL(String sExpectedURL){

        checkUrlToBe(sExpectedURL, urlToBe);

        return this;

    }

    //</editor-fold>

}
