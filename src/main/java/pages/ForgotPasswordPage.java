package pages;

import org.openqa.selenium.By;
import wrappers.BasePage;

public class ForgotPasswordPage extends BasePage {

    private By input_EmailAddressLocator = By.id("id_emailAddress");
    private By button_ForgotPasswordLocator = By.cssSelector("button");

    //type email address
    private ForgotPasswordPage typeEmailAddress(String sEmailAddress){
        type(input_EmailAddressLocator, sEmailAddress);
        return this;
    }

    //click on forgot password button
    private ForgotPasswordConfirmationPage clickOnForgotPasswordButton(){
        click(button_ForgotPasswordLocator);
        return new ForgotPasswordConfirmationPage();
    }

    //Forgot password page offers the user the service of being able to reset password
    public ForgotPasswordConfirmationPage goToForgotPasswordConfirmationPage(String sEmailAddress){
        return typeEmailAddress(sEmailAddress)
                .clickOnForgotPasswordButton();
    }

}
