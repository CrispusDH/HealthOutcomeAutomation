package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class ResourcesPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public ResourcesPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Resources page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By resourcesLocator = By.cssSelector(".resource");

    //find all resources
    private List<WebElement> resources(){

        return findElements(driver, resourcesLocator, 5000);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Final methods">

    //check that Resources page is not empty
    public boolean bodyIsEmpty(){

        return resources().isEmpty();

    }

    //check that Resources page has resources
    public boolean checkAmountOfResources(){

        return resources().size() > 0;

    }

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Resources", "url").equals(driver.getCurrentUrl());

    }

    //</editor-fold>

}
