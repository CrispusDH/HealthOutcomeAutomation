package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

import static utility.WaitConditionForWebElement.visible;
import static utility.WaitConditionForWebElements.allVisible;

public class ContactUsPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By div_ContactFormLocator = By.cssSelector(".contact-form");
    private By contactItemsLocator = By.cssSelector(".contact-items li");

    //find all inner items
    private List<WebElement> contactItems(){

        return waitForElements(contactItemsLocator, allVisible);
    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check that Contact Form on the page
    public ContactUsPage checkIsBodyEmpty(){

        Assert.assertTrue(waitFor(div_ContactFormLocator, visible).isDisplayed());

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
