package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class SingleReviewPage extends FindElementsNewMechanism{
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
    public WebElement div_ReviewInfo(){

        return findElements(driver, div_ReviewInfoLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //check that div_ReviewInfo element is displayed
    public boolean isOnPage(){

        return div_ReviewInfo().isDisplayed();

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
