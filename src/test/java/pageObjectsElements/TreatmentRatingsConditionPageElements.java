package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;


public class TreatmentRatingsConditionPageElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static WebElement link_ChangeCondition(WebDriver driver){
        element = findElements(driver, By.cssSelector(".change-condition"),5000).get(0);
        return element;
    }

}
