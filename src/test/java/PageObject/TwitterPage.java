package PageObject;

import org.openqa.selenium.WebDriver;
import utility.FindElementsNewMechanism;
import utility.ReadXMLFile;

public class TwitterPage extends FindElementsNewMechanism {
    private final WebDriver driver;

    public TwitterPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Base actions with elements">

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Twitter", "url" ).equals(driver.getCurrentUrl());

    }

    //</editor-fold>

}
