package PageObject;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class WriteAReviewConfirmationPage extends BaseClass {
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
    private WebElement form_SignUp(){

        return findElements(driver, form_SignUpLocator, 5000).get(0);

    }

    //find Review user name text field
    private WebElement txt_ReviewUserName (String UserName){

        elements = findElements(driver, txt_ReviewUserNameLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            i++;
        } while (!(element.getText().equals(UserName)));

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    public void isSignUpFormVisible(){

        Assert.assertTrue(form_SignUp().isDisplayed());

    }

    //</editor-fold>

}
