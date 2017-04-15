package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import static utility.WaitConditions.visible;

public class CreateAPrivateAccount extends BaseClass{

    private By GetStartedButtonLocator = By.cssSelector("[type=submit]");

    public CreateAPrivateAccount checkGetStartedButtonIsExist(){

        Assert.assertEquals("GET STARTED", ((WebElement) waitFor(GetStartedButtonLocator, visible)).getText());

        return this;
    }

}
