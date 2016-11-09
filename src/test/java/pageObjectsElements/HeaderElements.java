package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

public class HeaderElements extends FindElementsNewMechanism {
    private static WebElement element = null;


    public static WebElement lnk_LogIn(WebDriver driver){
        element = findElements(driver, By.linkText("Log In"),5000).get(0);
        return element;
    }

    public static WebElement lnk_SignUp(WebDriver driver){
        element = findElements(driver, By.linkText("Sign Up"),5000).get(0);
        return element;
    }

    public static WebElement lnk_SignOut(WebDriver driver){
        element = findElements(driver, By.linkText("Sign Out"),5000).get(0);
        return element;
    }

    public static WebElement lnk_Profile(WebDriver driver){
        element = findElements(driver, By.className("user-name"),5000).get(0);
        return element;
    }
}
