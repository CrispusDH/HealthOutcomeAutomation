package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.RandomNumber;
import utility.ReadXMLFile;

import java.util.List;

public class SignUpPage extends BaseClass {
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
    private WebElement input_EmailAddress(){

        return findElements(driver, input_EmailAddressLocator,5000).get(0);

    }

    //Password input field
    private WebElement input_Password(){

        return findElements(driver, input_PasswordLocator,5000).get(0);

    }

    //Join Now button
    private WebElement button_JoinNow(){

        return findElements(driver, button_JoinNowLocator,5000).get(0);

    }

    //Sign Up with Facebook button
    private WebElement button_SignUpWithFacebook(){

        return findElements(driver, button_SignUpWithFacebookLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //type email address
    private SignUpPage typeRandomEmailAddress(){

        input_EmailAddress().sendKeys((RandomNumber.createRandomNumber(Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "minRandomValue")), Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "maxRandomValue"))) + "@gmail.com"));

        return this;

    }

    //type password
    private SignUpPage typePassword(){

        input_Password().sendKeys(ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));

        return this;

    }

    //click on Join Now button
    private SignUpConfirmationPage clickOnJoinNowButton(){

        button_JoinNow().click();

        return new SignUpConfirmationPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //Sign Up page offers the user the service of being able to Sign Up via email
    public SignUpConfirmationPage signUpRandom(){

        //type email address
        typeRandomEmailAddress();

        //type password
        typePassword();

        //click on Join Now button
        return clickOnJoinNowButton();
    }

    //check page url
    public SignUpPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "SignUp Page from Videos&Guides Page", "url").equals(driver.getCurrentUrl()));

        return this;

    }

    //check that Join Now button exists
    public SignUpPage checkIsJoinNowButtonExists(){

        Assert.assertTrue(button_JoinNow().isDisplayed());

        return this;

    }

    //check that Sign up with Facebook button exists
    public SignUpPage checkIsSignUpWithFacebookButtonExists(){

        Assert.assertTrue(button_SignUpWithFacebook().isDisplayed());

        return this;

    }

    //</editor-fold>

}
