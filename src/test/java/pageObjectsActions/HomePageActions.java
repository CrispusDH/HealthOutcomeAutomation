package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.HomePageElements;
import utility.Constant;

public class HomePageActions {
    public static void logIn_Execute(WebDriver driver, String sEmailAddress, String sPassword){
        HomePageElements.inpt_EmailAddress(driver).sendKeys(sEmailAddress);
        HomePageElements.inpt_Password(driver).sendKeys(sPassword);
        HomePageElements.bttn_Login(driver).click();
        }

    public static void goToForgotPasswordPage(WebDriver driver){
        HomePageElements.lnk_ForgotPassword(driver).click();
        }

    public static void goToWriteAReviewPage(WebDriver driver){
        HomePageElements.bttn_StartHere(driver).click();
    }

    public static void goToSingleReviewPage(WebDriver driver){
        HomePageElements.frm_SingleReview(driver).click();
    }
}
