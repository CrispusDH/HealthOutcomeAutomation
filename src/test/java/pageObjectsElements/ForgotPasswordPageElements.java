package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

public class ForgotPasswordPageElements extends FindElementsNewMechanism{
    private static WebElement element = null;

    public static WebElement inpt_EmailAddress(WebDriver driver){
        element = findElements(driver, By.id("id_emailAddress"),5000).get(0);
        return element;
    }

    public static WebElement bttn_ForgotPassword(WebDriver driver){
        element = findElements(driver, By.cssSelector("button"),5000).get(0);
        return element;
    }
}
