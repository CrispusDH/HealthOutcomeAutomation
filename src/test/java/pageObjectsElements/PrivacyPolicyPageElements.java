package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;


public class PrivacyPolicyPageElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static List<WebElement> paragraphs (WebDriver driver){
        elements = findElements(driver, By.cssSelector(".post p"), 5000);
        return elements;
    }

}
