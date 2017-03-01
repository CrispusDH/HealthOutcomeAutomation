package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class SingleReviewPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public SingleReviewPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Single Review page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By div_ReviewInfoLocator = By.cssSelector(".review-info");

    //review info div
    private WebElement div_ReviewInfo(){

        return findElements(driver, div_ReviewInfoLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check that div_ReviewInfo element is displayed
    public boolean isOnPage(){

        return div_ReviewInfo().isDisplayed();

    }

    //</editor-fold>

}
