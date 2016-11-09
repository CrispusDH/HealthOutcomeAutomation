package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.reflect.FieldInfo;
import utility.FindElementsNewMechanism;

import java.util.List;

public class ResourcesPageElemetns extends FindElementsNewMechanism{
    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static List<WebElement> resources (WebDriver driver){
        elements = findElements(driver, By.cssSelector(".resource"), 5000);
        return elements;
    }
}
