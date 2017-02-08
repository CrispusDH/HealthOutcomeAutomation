package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.HeaderElements;

public class HeaderActions {

    //click on Log in link
    public static void clickOnLogIn(WebDriver driver){

        HeaderElements.link_LogIn(driver).click();

    }

    //click on SignUp link
    public static void clickOnSignUp (WebDriver driver){

        HeaderElements.link_SignUp(driver).click();

    }

    //click on SignOut link
    public static void clickOnSignOut (WebDriver driver){

        HeaderElements.link_SignOut(driver).click();

    }
}
