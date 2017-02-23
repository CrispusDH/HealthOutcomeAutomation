package PageObject;


import org.openqa.selenium.WebDriver;
import utility.FindElementsNewMechanism;
import utility.ReadXMLFile;

import java.util.concurrent.TimeUnit;

public class FacebookPage extends FindElementsNewMechanism{
    private final WebDriver driver;

    public FacebookPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Base actions with elements">

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Facebook", "url" ).equals(driver.getCurrentUrl());

    }

    //</editor-fold>

}
