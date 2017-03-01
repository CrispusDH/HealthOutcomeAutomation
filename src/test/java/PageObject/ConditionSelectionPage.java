package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConditionSelectionPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public ConditionSelectionPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Condition Selection page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By injuryBodyAreaLocator = By.cssSelector(".parts-list li > span");
    private By conditionElementLocator = By.cssSelector("#select-condition li a > span");
    private By forScrollingLocator = By.cssSelector(".select-step");

    //find all body areas
    private WebElement li_InjuryBodyArea(String bodyAreaName){

        elements = findElements(driver, injuryBodyAreaLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(bodyAreaName)));

        return element;
    }

    //find all conditions
    private WebElement li_ConditionElement(String ConditionName){

        elements = findElements(driver, conditionElementLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(ConditionName)));

        return element;
    }

    private WebElement forScrolling(){

        return findElements(driver, forScrollingLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //choose Body area name and click on it block
    private ConditionSelectionPage chooseBodyAreaName(String bodyAreaName){

        li_InjuryBodyArea(bodyAreaName).click();

        //wait 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;

    }

    //choose Condition and click
    private TreatmentRatingsConditionPage clickOnSpecificConditionName(String conditionName){

        //create new Action builder
        Actions builder = new Actions(driver);

        //scroll to element above
        builder.moveToElement(forScrolling());

        //click on specific Condition
        builder.click(li_ConditionElement(conditionName));

        //perform all actions
        builder.build().perform();

        return new TreatmentRatingsConditionPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    public TreatmentRatingsConditionPage goToTreatmentRatingsConditionPage(String bodyAreaName, String conditionName){

        //choose Body area name and click on it block
        chooseBodyAreaName(bodyAreaName);

        //choose Condition and click
        return clickOnSpecificConditionName(conditionName);

    }

    //get current url
    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //</editor-fold>

}
