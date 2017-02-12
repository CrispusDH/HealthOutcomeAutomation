package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class SpecificTreatmentReviewsPageElements extends FindElementsNewMechanism{

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    //Share your experience button
    public static WebElement button_ShareYourExperience (WebDriver driver){

        elements = findElements(driver, By.cssSelector(".banner-cta .button-cta span"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("SHARE YOUR EXPERIENCE")));

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
