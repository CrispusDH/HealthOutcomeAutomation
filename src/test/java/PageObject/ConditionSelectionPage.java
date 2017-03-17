package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseClass;
import static utility.WaitConditionForWebElement.visible;
import static utility.WaitConditionForWebElements.allVisible;

public class ConditionSelectionPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By injuryBodyAreaLocator = By.cssSelector(".parts-list li > span");
    private By conditionElementLocator = By.cssSelector("#select-condition li a > span");
    private By forScrollingLocator = By.cssSelector(".select-step");

    //find all body areas
    private WebElement li_InjuryBodyArea(String bodyAreaName){

        return findElementByText(waitForElements(injuryBodyAreaLocator, allVisible), bodyAreaName);

    }

    //find all conditions
    private WebElement li_ConditionElement(String sConditionName){

        return findElementByText(waitForElements(conditionElementLocator, allVisible), sConditionName);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //choose Body area name and click on it block
    private ConditionSelectionPage chooseBodyAreaName(String sBodyAreaName){

        click(li_InjuryBodyArea(sBodyAreaName));

        return this;

    }

    //choose Condition and click
    private TreatmentRatingsConditionPage clickOnSpecificConditionName(String conditionName){

        //create new Action builder
        Actions builder = new Actions(driver);

        //scroll to element above
        builder.moveToElement(waitFor(forScrollingLocator, visible));

        //click on specific Condition
        builder.click(li_ConditionElement(conditionName));

        //perform all actions
        builder.build().perform();

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

        Assert.assertEquals(sExpectedURL, driver.getCurrentUrl());

        return this;

    }

    //</editor-fold>

}
