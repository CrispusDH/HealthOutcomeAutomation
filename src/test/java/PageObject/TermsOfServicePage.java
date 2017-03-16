package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class TermsOfServicePage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    // The Terms of Service page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By paragraphsLocator = By.cssSelector(".post p");

    //find all paragraphs
    private List<WebElement> paragraphs(){

        return findElements(driver, paragraphsLocator, 5000);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check that page has text
    public TermsOfServicePage checkAmountOfParagraphs(){

        Assert.assertTrue(paragraphs().size() > 50);

        return this;

    }

    //check page url
    public TermsOfServicePage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Terms of Service", "url").equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
