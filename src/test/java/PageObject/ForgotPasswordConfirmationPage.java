package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class ForgotPasswordConfirmationPage extends FindElementsNewMechanism {
    private final WebDriver driver;

    public ForgotPasswordConfirmationPage(WebDriver driver){

        this.driver = driver;

    }
}
