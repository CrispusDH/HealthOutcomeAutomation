package PageObject;

import org.openqa.selenium.WebDriver;
import utility.BaseClass;
import utility.ReadXMLFile;

public class ForgotPasswordConfirmationPage extends BaseClass {
    private final WebDriver driver;

    public ForgotPasswordConfirmationPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Public methods">

    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Forgot Password Confirm", "url").equals(driver.getCurrentUrl());

    }

    //</editor-fold>

}
