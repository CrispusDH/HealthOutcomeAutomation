package pages;

import org.openqa.selenium.By;
import utility.BaseClass;

public class ForgotPasswordPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By input_EmailAddressLocator = By.id("id_emailAddress");
    private By button_ForgotPasswordLocator = By.cssSelector("button");

    //</editor-fold>

    //<editor-fold desc="Private methods">

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

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //Forgot password page offers the user the service of being able to reset password
    public ForgotPasswordConfirmationPage goToForgotPasswordConfirmationPage(String sEmailAddress){

        return typeEmailAddress(sEmailAddress)
                .clickOnForgotPasswordButton();

    }

    //</editor-fold>

}
