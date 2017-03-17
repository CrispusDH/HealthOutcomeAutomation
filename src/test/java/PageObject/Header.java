package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.RandomNumber;
import utility.ReadXMLFile;

import static utility.WaitConditionForWebElement.visible;
import static utility.WaitConditionForWebElements.allVisible;

public class Header extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By link_LogInLocator = By.linkText("Log In");
    private By link_SignUpLocator = By.linkText("Sign Up");
    private By link_SignOutLocator = By.linkText("Sign Out");
    private By link_ProfileLocator = By.className("user-name");
    private By button_ShareYourExperienceLocator = By.cssSelector(".button-cta span");

    //Share Your Experience button
    private WebElement button_ShareYourExperience (){

        return findElementByText(waitForElements(button_ShareYourExperienceLocator, allVisible), "SHARE YOUR EXPERIENCE");

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on Log in link
    private HomePage clickOnLogInLink(){

        click(link_LogInLocator);

        return new HomePage();

    }

    //click on SignUp link
    private SignUpPage clickOnSighUpLink(){

        click(link_SignUpLocator);

        return new SignUpPage();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //go to Sign Up page
    public SignUpPage goToSignUpPage(){

        return clickOnSighUpLink();

    }

    //open Log In form
    public HomePage openLogInForm(){

        return clickOnLogInLink();

    }

    //check username
    public Header checkUserName(){

        Assert.assertEquals(ReadXMLFile.takeConstantFromXML("Account", "Main", "userName"), waitFor(link_ProfileLocator, visible).getText());

        return this;

    }

    //check User Name for Random created user
    public Header checkUserNameForRandomCreatedUser(){

        Assert.assertTrue(waitFor(link_ProfileLocator, visible).getText().equals(String.valueOf(RandomNumber.currentRandomNumber())));

        return this;

    }

    //</editor-fold>

}
