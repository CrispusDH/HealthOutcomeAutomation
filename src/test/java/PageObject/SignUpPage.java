package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;
import utility.RandomNumber;
import utility.ReadXMLFile;

import java.util.List;

public class SignUpPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public SignUpPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Sign Up page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By input_EmailAddressLocator = By.id("id_username");
    private By input_PasswordLocator = By.id("id_password");
    private By button_JoinNowLocator = By.cssSelector(".button.signup");
    private By button_SignUpWithFacebookLocator = By.cssSelector(".facebook-login-feature a");

    //Email Address input field
    public WebElement input_EmailAddress(){

        return findElements(driver, input_EmailAddressLocator,5000).get(0);

    }

    //Password input field
    public WebElement input_Password(){

        return findElements(driver, input_PasswordLocator,5000).get(0);

    }

    //Join Now button
    public WebElement button_JoinNow(){

        return findElements(driver, button_JoinNowLocator,5000).get(0);

    }

    //Sign Up with Facebook button
    public WebElement button_SignUpWithFacebook(){

        return findElements(driver, button_SignUpWithFacebookLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //type email address
    public SignUpPage typeRandomEmailAddress(){

        input_EmailAddress().sendKeys((RandomNumber.createRandomNumber(Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "minRandomValue")), Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "maxRandomValue"))) + "@gmail.com"));

        return this;

    }

    //type password
    public SignUpPage typePassword(String sPassword){

        input_Password().sendKeys(sPassword);

        return this;

    }

    //click on Join Now button
    public SignUpConfirmationPage clickOnJoinNowButton(){

        button_JoinNow().click();

        return new SignUpConfirmationPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">

    //Sign Up page offers the user the service of being able to Sign Up via email
    public SignUpConfirmationPage signUpRandom(String sPassword){

        //type email address
        typeRandomEmailAddress();

        //type password
        typePassword(sPassword);

        //click on Join Now button
        return clickOnJoinNowButton();
    }

    //</editor-fold>

}