package pages;

import utility.BasePage;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;

public class ForgotPasswordConfirmationPage extends BasePage {

    //check page url
    public ForgotPasswordConfirmationPage checkUrl(){
        checkUrlToBe("Forgot Password Confirm");
        return this;
    }

}
