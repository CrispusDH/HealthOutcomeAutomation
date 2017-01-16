package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class HeaderElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

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

    //Share Your Experience button
    public static WebElement button_ShareYourExperience (WebDriver driver){
        elements = findElements(driver, By.cssSelector(".button-cta span"), 5000);
        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("SHARE YOUR EXPERIENCE")));
        return element;
    }
}
