package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import static waiters.WaitConditions.visible;

public class CreateAPrivateAccount extends BasePage {

    private By GetStartedButtonLocator = By.cssSelector("[type=submit]");
    private By nameInputLocator = By.cssSelector("#id_name");
    private By emailInputLocator = By.cssSelector("#id_username");
    private By confirmEmailInputLocator = By.cssSelector("#id_usernameConfirm");
    private By passwordInputLocator = By.cssSelector("#id_password");

    public CreateAPrivateAccount checkGetStartedButtonIsExist(){
        Assert.assertEquals("GET STARTED", ((WebElement) waitFor(GetStartedButtonLocator, visible)).getText());
        return this;
    }

    private CreateAPrivateAccount typeName(String sName){
        type(nameInputLocator, sName);
        return this;
    }

    private CreateAPrivateAccount typeEmail(String sEmail){
        type(emailInputLocator, sEmail);
        return this;
    }

    private CreateAPrivateAccount typeConfirmEmail(String sConfirmEmail){
        type(confirmEmailInputLocator, sConfirmEmail);
        return this;
    }

    private CreateAPrivateAccount typePassword(String sPassword){
        type(passwordInputLocator, sPassword);
        return this;
    }

    public void fillForm(String sName, String sEmail, String sConfirmEmail, String sPassword){
         typeName(sName)
                .typeEmail(sEmail)
                .typeConfirmEmail(sConfirmEmail)
                .typePassword(sPassword)
                .click((WebElement) waitFor(GetStartedButtonLocator, visible));
    }

}
