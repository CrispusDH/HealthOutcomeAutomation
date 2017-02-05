package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;


public class SignUpPageElements extends FindElementsNewMechanism {
    private static WebElement element = null;

    //Email Address input field
    public static WebElement input_EmailAddress(WebDriver driver){
        element = findElements(driver, By.id("id_username"),5000).get(0);
        return element;
    }

    //Password input field
    public static WebElement input_Password(WebDriver driver){
        element = findElements(driver, By.id("id_password"),5000).get(0);
        return element;
    }

    //Join Now button
    public static WebElement button_JoinNow(WebDriver driver){
        element = findElements(driver, By.cssSelector(".button.signup"),5000).get(0);
        return element;
    }

    //Sign Up with Facebook button
    public static WebElement button_SignUpWithFacebook(WebDriver driver){
        element = findElements(driver, By.cssSelector(".facebook-login-feature a"),5000).get(0);
        return element;
    }

}
