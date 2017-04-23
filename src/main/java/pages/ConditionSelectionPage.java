package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import java.util.concurrent.TimeUnit;

import static waiters.WaitConditionForUrl.urlToBe;
import static waiters.WaitConditions.allPresence;

public class ConditionSelectionPage extends BasePage {

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

    public TreatmentRatingsConditionPage goToTreatmentRatingsConditionPage(String bodyAreaName, String conditionName){
        chooseBodyAreaName(bodyAreaName);
        return clickOnSpecificConditionName(conditionName);
    }

    //check URL
    public ConditionSelectionPage checkURL(String sExpectedURL){
        checkUrlToBe(sExpectedURL, urlToBe);
        return this;
    }

}
