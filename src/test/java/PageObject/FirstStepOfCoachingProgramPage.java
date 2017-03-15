package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class FirstStepOfCoachingProgramPage extends BaseClass {
    private WebElement element;
    private List<WebElement> elements;

    public FirstStepOfCoachingProgramPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The First step of coaching program page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.


    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check page url
    public FirstStepOfCoachingProgramPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "First Step Of Coaching Program", "url" ).equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
