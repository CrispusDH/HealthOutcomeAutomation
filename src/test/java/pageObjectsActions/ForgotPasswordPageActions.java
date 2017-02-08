package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.ForgotPasswordPageElements;

public class ForgotPasswordPageActions {

    public static void forgotPassword_Execute(WebDriver driver, String sEmailAddress){

        //type email address
        ForgotPasswordPageElements.input_EmailAddress(driver).sendKeys(sEmailAddress);

        //click on forgot password button
        ForgotPasswordPageElements.button_ForgotPassword(driver).click();
    }

}
