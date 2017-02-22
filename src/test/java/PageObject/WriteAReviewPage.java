package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class WriteAReviewPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public WriteAReviewPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Write a Review Confirmation page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By text_GroupTitleLocator = By.cssSelector(".group-title");

    //
    public WebElement text_GroupTitle (){

        return findElements(driver, text_GroupTitleLocator, 5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">



    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
