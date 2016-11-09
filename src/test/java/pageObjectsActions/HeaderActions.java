package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.HeaderElements;

public class HeaderActions {
    public static void clickOnLogIn(WebDriver driver){
        HeaderElements.lnk_LogIn(driver).click();
    }

    public static void clickOnSignUp (WebDriver driver){
        HeaderElements.lnk_SignUp(driver).click();
    }

    public static void clickOnSignOut (WebDriver driver){
        HeaderElements.lnk_SignOut(driver).click();
    }
}
