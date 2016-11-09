package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class WriteAReviewConfirmationPageElements extends FindElementsNewMechanism{
    private static WebElement element = null;
    private static List<WebElement> elements = null;

    public static WebElement frm_SignUp(WebDriver driver){
        element = findElements(driver, By.cssSelector(".signup-static"), 5000).get(0);
        return element;
    }

    public static WebElement txt_ReviewUserName (WebDriver driver, String UserName){
        elements = findElements(driver, By.cssSelector(".review-user .user-name"), 5000);
        int i = 0;
        do {
            element = elements.get(i);
            i++;
        } while (!(element.getText().equals(UserName)));
        return element;
    }


}
