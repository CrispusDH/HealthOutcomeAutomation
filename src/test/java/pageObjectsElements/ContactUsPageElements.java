package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class ContactUsPageElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static WebElement div_ContactForm(WebDriver driver){
        element = findElements(driver, By.cssSelector(".contact-form"),5000).get(0);
        return element;
    }

    public static List<WebElement> contactItems (WebDriver driver){
        elements = findElements(driver, By.cssSelector(".contact-items li"), 5000);
        return elements;
    }

}
