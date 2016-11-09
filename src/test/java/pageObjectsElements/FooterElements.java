package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class FooterElements extends FindElementsNewMechanism {
    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static WebElement lnk_FooterLink (WebDriver driver, String FooterLinkName){
        elements = findElements(driver, By.cssSelector(".links li"), 5000);
        int i = 0;
        do {
            element = elements.get(i);
            i++;
        } while (!(element.getText().equals(FooterLinkName)));
        return element;
    }
}
