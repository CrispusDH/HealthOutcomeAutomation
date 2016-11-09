package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.ForgotPasswordPageElements;
import utility.Constant;

public class ForgotPasswordPageActions {
    public static void forgotPassword_Execute(WebDriver driver, String sEmailAddress){
        ForgotPasswordPageElements.inpt_EmailAddress(driver).sendKeys(sEmailAddress);
        ForgotPasswordPageElements.bttn_ForgotPassword(driver).click();
    }

}
