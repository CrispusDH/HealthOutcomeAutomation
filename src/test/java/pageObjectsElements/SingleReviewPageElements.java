package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

public class SingleReviewPageElements extends FindElementsNewMechanism{
    private static WebElement element = null;

    public static WebElement div_ReviewInfo(WebDriver driver){
        element = findElements(driver, By.cssSelector(".review-info"),5000).get(0);
        return element;
    }
}
