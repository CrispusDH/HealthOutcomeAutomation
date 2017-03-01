package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class FAQPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public FAQPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The FAQ page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By questionsLocator = By.cssSelector(".questions li");

    private List<WebElement> questions(){

        return findElements(driver, questionsLocator, 5000);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check that FAQ are not empty
    public boolean bodyIsEmpty(){

        return questions().isEmpty();

    }

    //check that FAQ page has paragraphs
    public boolean amountOfQustions(){

        return questions().size() > 0;

    }

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "FAQ", "url").equals(driver.getCurrentUrl());

    }

    //</editor-fold>

}
