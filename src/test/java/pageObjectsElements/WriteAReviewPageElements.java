package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;


public class WriteAReviewPageElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    //find all Body areas
    public static WebElement li_InjuryBodyArea (WebDriver driver, String BodyAreaName){

        elements = findElements(driver, By.cssSelector(".parts-list li"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            i++;
        } while (!(element.getText().equals(BodyAreaName)));

        return element;
    }

    //find all Conditions
    public static WebElement li_ConditionElement (WebDriver driver, String ConditionName){

        elements = findElements(driver, By.cssSelector("#conditionList li"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(ConditionName)));

        return element;
    }

    //find all treatments
    public static WebElement li_TreatmentsElement (WebDriver driver, String TreatmentName){

        elements = findElements(driver, By.cssSelector(".field-treatments li"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(TreatmentName)));

        return element;
    }

    //find all Rates
    public static WebElement li_RateYourTreatmentsFirstElement(WebDriver driver, String RateChoice){

        elements = findElements(driver, By.cssSelector(".field-satisfactionLevel li"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(RateChoice)));

        return element;
    }

    //Post Review button
    public static WebElement button_PostReview(WebDriver driver){

        elements = findElements(driver, By.cssSelector("button"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            i++;
            } while (!(element.getText().equals("POST REVIEW")));

        return element;
    }

}
