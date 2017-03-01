package PageObject;


import org.openqa.selenium.WebDriver;
import utility.BaseClass;
import utility.ReadXMLFile;

public class FacebookPage extends BaseClass {

    private final WebDriver driver;

    public FacebookPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Public methods">

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Facebook", "url" ).equals(driver.getCurrentUrl());

    }

    //</editor-fold>

}
