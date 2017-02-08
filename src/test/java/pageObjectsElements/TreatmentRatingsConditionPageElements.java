package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;


public class TreatmentRatingsConditionPageElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    //find Change condition link
    public static WebElement link_ChangeCondition(WebDriver driver){

        element = findElements(driver, By.cssSelector(".change-condition"),5000).get(0);

        return element;
    }

    //Learn More button
    public static WebElement button_LearnMore (WebDriver driver){

        elements = findElements(driver, By.cssSelector(".button-cta span"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("LEARN MORE   ")));

        return element;
    }

    //Find tab
    public static WebElement tab (WebDriver driver, String tabName){

        elements = findElements(driver, By.cssSelector(".hero-tabs li"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(tabName)));

        return element;
    }

}
