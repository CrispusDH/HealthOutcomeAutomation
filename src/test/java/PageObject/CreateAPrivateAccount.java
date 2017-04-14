package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import utility.BaseClass;
import static utility.WaitConditionForWebElement.visible;

public class CreateAPrivateAccount extends BaseClass{

    private By GetStartedButtonLocator = By.cssSelector("[type=submit]");

    public CreateAPrivateAccount checkGetStartedButtonIsExist(){

        Assert.assertEquals("GET STARTED", waitFor(GetStartedButtonLocator, visible).getText());

        return this;
    }

}
