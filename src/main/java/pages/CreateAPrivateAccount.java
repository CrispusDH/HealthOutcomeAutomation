package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import static waiters.WaitConditions.visible;

public class CreateAPrivateAccount extends BasePage {

    private By GetStartedButtonLocator = By.cssSelector("[type=submit]");

    public CreateAPrivateAccount checkGetStartedButtonIsExist(){
        Assert.assertEquals("GET STARTED", ((WebElement) waitFor(GetStartedButtonLocator, visible)).getText());
        return this;
    }

}
