package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;


public class ConditionSelectionPageElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    //find all body areas
    public static WebElement li_InjuryBodyArea (WebDriver driver, String BodyAreaName){

        elements = findElements(driver, By.cssSelector(".parts-list li > span"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(BodyAreaName)));

        return element;
    }

    //find all conditions
    public static WebElement li_ConditionElement (WebDriver driver, String ConditionName){

        elements = findElements(driver, By.cssSelector("#select-condition li a > span"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(ConditionName)));

        return element;
    }

}
