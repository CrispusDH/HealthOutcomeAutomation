package PageObject;

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
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "About Us", "url").equals(driver.getCurrentUrl());

    }

    //check that About Us page has paragraphs
    public boolean checkAmountOfParagraphs(){

        return paragraphs().size() > 0;

    }

    //check that AboutUS body are not empty
    public boolean checkIsEmpty(){

        return paragraphs().isEmpty();

    }

    //</editor-fold>

}
