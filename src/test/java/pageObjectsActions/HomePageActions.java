package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.HomePageElements;

public class HomePageActions {

    public static void logIn_Execute(WebDriver driver, String sEmailAddress, String sPassword){

        //type email address
        HomePageElements.input_EmailAddress(driver).sendKeys(sEmailAddress);

        //type password
        HomePageElements.input_Password(driver).sendKeys(sPassword);

        //click on Login button
        HomePageElements.button_Login(driver).click();
        }

    public static void goToForgotPasswordPage(WebDriver driver){

        HomePageElements.link_ForgotPassword(driver).click();

        }

    public static void goToWriteAReviewPage(WebDriver driver){
        HomePageElements.button_StartHere(driver).click();
    }

    public static void goToSingleReviewPage(WebDriver driver){
        HomePageElements.form_SingleReview(driver).click();
    }

    //go to Treatment Ratings Condition page
    public static void goToFeaturedConditionPage(WebDriver driver){

        HomePageElements.li_FeaturedConditions(driver).click();

    }

    //go to Condition Selection page
    public static void clickGetStartedButton(WebDriver driver){

        HomePageElements.button_GetStarted(driver).click();

    }
}
