package pageObjectsElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class DetailedBlogPageElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    //Start Here button
    public static WebElement button_StartHere (WebDriver driver){
        elements = findElements(driver, By.cssSelector(".button-cta span"), 5000);
        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("START HERE")));
        return element;
    }

    //Find Out More button
    public static WebElement button_FindOutMore (WebDriver driver){
        elements = findElements(driver, By.cssSelector(".button-cta span"), 5000);
        int i = 0;
        do {
            element = elements.get(i);
            System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("Find Out More")));
        return element;
    }

}
