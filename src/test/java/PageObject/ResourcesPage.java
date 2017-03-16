package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class ResourcesPage extends BaseClass {

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
    public ResourcesPage checkIsBodyEmpty(){

        Assert.assertTrue(!resources().isEmpty());

        return this;

    }

    //check that Resources page has resources
    public ResourcesPage checkAmountOfResources(){

        Assert.assertTrue(resources().size() > 0);

        return this;

    }

    //check page url
    public ResourcesPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Resources", "url").equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
