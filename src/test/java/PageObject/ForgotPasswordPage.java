package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class ForgotPasswordPage extends BaseClass {
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
    private WebElement input_EmailAddress(){

        return findElements(driver, input_EmailAddressLocator, 5000).get(0);

    }

    //find forgot password button
    private WebElement button_ForgotPassword(){

        return findElements(driver, button_ForgotPasswordLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //type email address
    private ForgotPasswordPage typeEmailAddress(String sEmailAddress){

        input_EmailAddress().sendKeys(sEmailAddress);

        return this;

    }

    //click on forgot password button
    private ForgotPasswordConfirmationPage clickOnForgotPasswordButton(){

        button_ForgotPassword().click();

        return new ForgotPasswordConfirmationPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //Forgot password page offers the user the service of being able to reset password
    public ForgotPasswordConfirmationPage goToForgotPasswordConfirmationPage(String sEmailAddress){

        //type email address
        typeEmailAddress(sEmailAddress);

        //click on forgot password button
        return clickOnForgotPasswordButton();

    }

    //</editor-fold>

}
