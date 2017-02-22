package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class TestimonialsPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public TestimonialsPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Testimonials page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By cardsLocator = By.cssSelector(".body-content");

    //find all cards on a page
    public List<WebElement> cards (){

        return findElements(driver, cardsLocator, 5000);

    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">



    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
