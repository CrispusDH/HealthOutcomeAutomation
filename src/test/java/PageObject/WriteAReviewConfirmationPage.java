package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class WriteAReviewConfirmationPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public WriteAReviewConfirmationPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Write a Review Confirmation page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By form_SignUpLocator = By.cssSelector(".signup-static");
    private By txt_ReviewUserNameLocator = By.cssSelector(".review-user .user-name");

    //find SignUp form
    public WebElement form_SignUp(){

        return findElements(driver, form_SignUpLocator, 5000).get(0);

    }

    //find Review user name text field
    public WebElement txt_ReviewUserName (String UserName){

        elements = findElements(driver, txt_ReviewUserNameLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            i++;
        } while (!(element.getText().equals(UserName)));

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">



    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
