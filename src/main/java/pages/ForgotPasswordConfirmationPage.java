package pages;

import wrappers.BasePage;

public class ForgotPasswordConfirmationPage extends BasePage {

    //check page url
    public ForgotPasswordConfirmationPage checkUrl(){
        checkUrlToBe("Forgot Password Confirm");
        return this;
    }

}
