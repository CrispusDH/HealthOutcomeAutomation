package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;
import utility.ReadXMLFile;

import java.util.List;

public class ForgotPasswordConfirmationPage extends FindElementsNewMechanism {
    private final WebDriver driver;

    public ForgotPasswordConfirmationPage(WebDriver driver){

        this.driver = driver;

    }

    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Forgot Password Confirm", "url").equals(driver.getCurrentUrl());

    }

}
