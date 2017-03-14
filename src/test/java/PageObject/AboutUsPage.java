package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class AboutUsPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public AboutUsPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The About Us page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By paragraphsLocator = By.cssSelector(".post p");

    //find all paragraphs on page
    private List<WebElement> paragraphs(){

        return findElements(driver, By.cssSelector(".post p"), 5000);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check page url
    public AboutUsPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "About Us", "url").equals(driver.getCurrentUrl()));

        return this;

    }

    //check that About Us page has paragraphs
    public AboutUsPage checkAmountOfParagraphs(){

        Assert.assertTrue(paragraphs().size() > 0);

        return this;

    }

    //check that AboutUS body are not empty
    public AboutUsPage checkIsEmpty(){

        Assert.assertTrue(!paragraphs().isEmpty());

        return this;

    }

    //</editor-fold>

}
