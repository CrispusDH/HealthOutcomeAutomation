package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;


public class SignUpPageElements extends FindElementsNewMechanism {
    private static WebElement element = null;

    public static WebElement inpt_EmailAddress(WebDriver driver){
        element = findElements(driver, By.id("id_username"),5000).get(0);
        return element;
    }

    public static WebElement inpt_Password(WebDriver driver){
        element = findElements(driver, By.id("id_password"),5000).get(0);
        return element;
    }

    public static WebElement bttn_JoinNow(WebDriver driver){
        element = findElements(driver, By.cssSelector(".button.signup"),5000).get(0);
        return element;
    }
}
