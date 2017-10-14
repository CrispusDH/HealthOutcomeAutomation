package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.RandomNumber;
import wrappers.BasePage;

import static waiters.WaitConditions.visible;

public class RegistrationVerifyPage extends BasePage{

    private By emailLocator = By.cssSelector(".registration-verify-form b");

    public RegistrationVerifyPage checkEmail(){
        Assert.assertEquals(
            (String.valueOf(RandomNumber.currentRandomNumber())) + "@gmail.com",
            ((WebElement) waitFor(emailLocator, visible)).getText());
        return this;
    }

}
