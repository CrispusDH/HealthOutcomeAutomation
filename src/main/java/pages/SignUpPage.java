package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.RandomNumber;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.visible;


public class SignUpPage extends BasePage {

    private By input_EmailAddressLocator = By.id("id_username");
    private By input_PasswordLocator = By.id("id_password");
    private By button_JoinNowLocator = By.cssSelector(".button.signup");
    private By button_SignUpWithFacebookLocator = By.cssSelector(".facebook-login-feature a");

    //type email address
    private SignUpPage typeRandomEmailAddress(){
        type(input_EmailAddressLocator, (RandomNumber.createRandomNumber(Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "minRandomValue")), Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "maxRandomValue"))) + "@gmail.com"));
        return this;
    }

    //type password
    private SignUpPage typePassword(){
        type(input_PasswordLocator, ReadXMLFile.takeConstantFromXML("Account", "Main", "password"));
        return this;
    }

    //click on Join Now button
    private SignUpConfirmationPage clickOnJoinNowButton(){
        click(button_JoinNowLocator);
        return new SignUpConfirmationPage();
    }

    //Sign Up page offers the user the service of being able to Sign Up via email
    public SignUpConfirmationPage signUpRandom(){
        return typeRandomEmailAddress()
                    .typePassword()
                    .clickOnJoinNowButton();
    }

    //check page url
    public SignUpPage checkUrl(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "SignUp Page from Videos&Guides Page", "url"), urlToBe);
        return this;
    }

    //check that Join Now button exists
    public SignUpPage checkIsJoinNowButtonExists(){
        Assert.assertTrue(((WebElement) waitFor(button_JoinNowLocator, visible)).isDisplayed());
        return this;
    }

    //check that Sign up with Facebook button exists
    public SignUpPage checkIsSignUpWithFacebookButtonExists(){
        Assert.assertTrue(((WebElement) waitFor(button_SignUpWithFacebookLocator, visible)).isDisplayed());
        return this;
    }

}