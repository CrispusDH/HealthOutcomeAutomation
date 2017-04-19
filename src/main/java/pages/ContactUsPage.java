package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;
import static utility.WaitConditions.visible;

public class ContactUsPage extends BasePage {

    private By div_ContactFormLocator = By.cssSelector(".contact-form");
    private By contactItemsLocator = By.cssSelector(".contact-items li");

    //find all inner items
    private List<WebElement> contactItems(){
        return waitForElements(contactItemsLocator, allPresence);
    }

    //check that Contact Form on the page
    public ContactUsPage checkIsBodyEmpty(){
        Assert.assertTrue(((WebElement) waitFor(div_ContactFormLocator, visible)).isDisplayed());
        return this;
    }

    //check that all items are on page
    public ContactUsPage checkAmountOfItems(){
        Assert.assertTrue(contactItems().size() == 3);
        return this;
    }

    //check page url
    public ContactUsPage checkUrl(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Contact Us", "url"), urlToBe);
        return this;
    }

}
