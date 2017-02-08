package pageObjectsElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class FooterElements extends FindElementsNewMechanism {

    private static WebElement element = null;
    private static List<WebElement> elements = null;

    //find all footer links
    public static WebElement link_FooterLink(WebDriver driver, String FooterLinkName){

        elements = findElements(driver, By.cssSelector(".links li"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(FooterLinkName)));

        return element;
    }

    //find all items in copyrights block
    public static WebElement link_FooterCopyrights (WebDriver driver, String FooterCopyrightName){

        elements = findElements(driver, By.cssSelector(".copyright a"), 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(FooterCopyrightName)));

        return element;
    }


    //facebook, twitter, linkedin, mailto links
    public static WebElement link_Connect(WebDriver driver, String name){

        elements = findElements(driver, By.cssSelector(".connect li a"), 5000);

        //System.out.println(elements.get(0).getTagName());
        switch (name){

            case "facebook":
                return element = elements.get(0);

            case "twitter":
                return element = elements.get(1);

            case "linkedin":
                return element = elements.get(2);

            case "mail":
                return element = elements.get(3);

        }

        return element;
    }


}
