package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;


public class HomePageElements extends FindElementsNewMechanism {
    private static WebElement element = null;

    public static WebElement inpt_EmailAddress(WebDriver driver){
        element = findElements(driver, By.id("id_username"),5000).get(0);
        return element;
    }

    public static WebElement inpt_Password(WebDriver driver){
        element = findElements(driver, By.id("id_password"),5000).get(0);
        return element;
    }

    public static WebElement bttn_Login(WebDriver driver){
        element = findElements(driver, By.tagName("button"),5000).get(0);
        return element;
    }

    public static WebElement bttn_GetStarted(WebDriver driver){
        element = findElements(driver, By.cssSelector("a[href*='/condition-selection']"),5000).get(0);
        return element;
    }

    public static WebElement lnk_ForgotPassword(WebDriver driver){
        element = findElements(driver, By.linkText("Forgot password?"),5000).get(0);
        return element;
    }

    public static WebElement bttn_StartHere(WebDriver driver){
        element = findElements(driver, By.cssSelector("html body div#content div.page.page-home div.page-body div div.share-experience-bar-cta div.bar-body.body-content a.button.button-cta"), 5000).get(0);
        return element;
    }

    public static WebElement frm_SingleReview(WebDriver driver){
        element = findElements(driver, By.cssSelector(".review-info"),5000).get(0);
        return element;
    }

}
