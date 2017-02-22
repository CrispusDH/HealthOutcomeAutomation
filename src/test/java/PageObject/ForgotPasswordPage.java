package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class ForgotPasswordPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public ForgotPasswordPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Forgot password page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By input_EmailAddressLocator = By.id("id_emailAddress");
    private By button_ForgotPasswordLocator = By.cssSelector("button");

    //find email address input field
    public WebElement input_EmailAddress(){

        return findElements(driver, input_EmailAddressLocator, 5000).get(0);

    }

    //find forgot password button
    public WebElement button_ForgotPassword(){

        return findElements(driver, button_ForgotPasswordLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //type email address
    public ForgotPasswordPage typeEmailAddress(String sEmailAddress){

        input_EmailAddress().sendKeys(sEmailAddress);

        return this;

    }

    //click on forgot password button
    public ForgotPasswordConfirmationPage clickOnForgotPasswordButton(){

        button_ForgotPassword().click();

        return new ForgotPasswordConfirmationPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">

    //Forgot password page offers the user the service of being able to reset password
    public ForgotPasswordConfirmationPage resetPassword(String sEmailAddress){

        //type email address
        typeEmailAddress(sEmailAddress);

        //click on forgot password button
        return clickOnForgotPasswordButton();

    }

    //</editor-fold>

}