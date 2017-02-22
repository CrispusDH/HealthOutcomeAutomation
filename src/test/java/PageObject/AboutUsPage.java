package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;
import utility.ReadXMLFile;

import java.util.List;

public class AboutUsPage extends FindElementsNewMechanism{
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
    public List<WebElement> paragraphs (){

        return findElements(driver, By.cssSelector(".post p"), 5000);

    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //check that AboutUS body are not empty
    public boolean bodyIsEmpty(){

        return paragraphs().isEmpty();

    }

    //check that About Us page has paragraphs
    public boolean amountOfParagraphs(){

        return paragraphs().size() > 0;

    }

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "About Us", "url").equals(driver.getCurrentUrl());

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
