package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.RandomNumber;
import utility.ReadXMLFile;

import java.util.List;

public class Header extends BaseClass {
    private WebElement element;
    private List<WebElement> elements;

    public Header(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Header contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By link_LogInLocator = By.linkText("Log In");
    private By link_SignUpLocator = By.linkText("Sign Up");
    private By link_SignOutLocator = By.linkText("Sign Out");
    private By lnk_ProfileLocator = By.className("user-name");
    private By button_ShareYourExperienceLocator = By.cssSelector(".button-cta span");

    //find Log in link
    private WebElement link_LogIn(){

        return findElements(driver, link_LogInLocator,5000).get(0);

    }

    //find SignUp link
    private WebElement link_SignUp(){

        return findElements(driver, link_SignUpLocator,5000).get(0);

    }

    //find SignOut link
    private WebElement link_SignOut(){

         return findElements(driver, link_SignOutLocator,5000).get(0);

    }

    //find Profile link
    private WebElement link_Profile(){

        return findElements(driver, lnk_ProfileLocator,5000).get(0);

    }

    //Share Your Experience button
    private WebElement button_ShareYourExperience (){

        elements = findElements(driver, button_ShareYourExperienceLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("SHARE YOUR EXPERIENCE")));

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on Log in link
    private HomePage clickOnLogInLink(){

        link_LogIn().click();

        return new HomePage(driver);

    }

    //click on SignUp link
    private SignUpPage clickOnSighUpLink(){

        link_SignUp().click();

        return new SignUpPage(driver);

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

        Assert.assertEquals(ReadXMLFile.takeConstantFromXML("Account", "Main", "userName"), link_Profile().getText());

        return this;

    }

    //check User Name for Random created user
    public Header checkUserNameForRandomCreatedUser(){

        Assert.assertTrue(link_Profile().getText().equals(String.valueOf(RandomNumber.currentRandomNumber())));

        return this;

    }

    //</editor-fold>

}
