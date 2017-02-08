package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class SignUpConfirmationPageElements extends FindElementsNewMechanism{

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    //find Write a review or Find Treatments button
    public static WebElement button_WriteAReviewOrFindTreatments(WebDriver driver, String ButtonName){

        elements = findElements(driver, By.cssSelector(".action"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            i++;
        } while (!(element.getText().equals(ButtonName)));
        //System.out.println(element.getText());

        return element;
    }
}
