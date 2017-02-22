package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class ContactUsPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public ContactUsPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Contact Us page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By div_ContactFormLocator = By.cssSelector(".contact-form");
    private By contactItemsLocator = By.cssSelector(".contact-items li");

    //find Contact form
    public WebElement div_ContactForm(){

        return findElements(driver, div_ContactFormLocator,5000).get(0);

    }

    //find all inner items
    public List<WebElement> contactItems (){

        return findElements(driver, contactItemsLocator, 5000);
    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">



    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
