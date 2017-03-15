package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class ContactUsPage extends BaseClass {
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
    private WebElement div_ContactForm(){

        return findElements(driver, div_ContactFormLocator,5000).get(0);

    }

    //find all inner items
    private List<WebElement> contactItems(){

        return findElements(driver, contactItemsLocator, 5000);
    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check that Contact Form on the page
    public ContactUsPage checkIsBodyEmpty(){

        Assert.assertTrue(div_ContactForm().isDisplayed());

        return this;

    }

    //check that all items are on page
    public ContactUsPage checkAmountOfItems(){

        Assert.assertTrue(contactItems().size() == 3);

        return this;

    }

    //check page url
    public ContactUsPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Contact Us", "url").equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
