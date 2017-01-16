package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;


public class HomePageElements extends FindElementsNewMechanism {
    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static WebElement input_EmailAddress(WebDriver driver){
        element = findElements(driver, By.id("id_username"),5000).get(0);
        return element;
    }

    public static WebElement input_Password(WebDriver driver){
        element = findElements(driver, By.id("id_password"),5000).get(0);
        return element;
    }

    public static WebElement button_Login(WebDriver driver){
        element = findElements(driver, By.tagName("button"),5000).get(0);
        return element;
    }

    public static WebElement button_GetStarted(WebDriver driver){
        //element = findElements(driver, By.cssSelector("a[href*='/condition-selection']"),5000).get(0);
        element = findElements(driver, By.cssSelector(".hero-titles a"),5000).get(0);
        return element;
    }

    public static WebElement lnk_ForgotPassword(WebDriver driver){
        element = findElements(driver, By.linkText("Forgot password?"),5000).get(0);
        return element;
    }

    //Start Here button
    public static WebElement button_StartHere (WebDriver driver){
        elements = findElements(driver, By.cssSelector(".button-cta span"), 5000);
        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("START HERE")));
        return element;
    }

    public static WebElement form_SingleReview(WebDriver driver){
        element = findElements(driver, By.cssSelector(".review-info"),5000).get(0);
        return element;
    }

    //left Condition
    public static WebElement li_FeaturedConditions(WebDriver driver){

        element = findElements(driver, By.cssSelector(".condition.left > .condition-link"),5000).get(0);
        return element;
    }

}
