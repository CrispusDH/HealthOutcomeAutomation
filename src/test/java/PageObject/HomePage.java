package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import static utility.WaitConditionForWebElement.visible;
import static utility.WaitConditionForWebElements.allPresence;

public class HomePage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By input_EmailAddressLocator = By.id("id_username");
    private By input_PasswordLocator = By.id("id_password");
    private By button_LoginLocator = By.tagName("button");
    private By button_GetStartedLocator = By.cssSelector(".hero-titles a");
    private By link_ForgotPasswordLocator = By.linkText("Forgot password?");
    private By button_StartHereLocator = By.cssSelector(".body-content .button-cta span");
    private By form_SingleReviewLocator = By.cssSelector(".review-info");
    private By link_FeaturedConditionLocator = By.cssSelector(".condition.left > .condition-link");

    //Start Here button
    private WebElement button_StartHere(){

        return findElementByText(waitForElements(button_StartHereLocator, allPresence), "START HERE");

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //type email address
    private HomePage typeEmailAddress(String sEmailAddress){

        type(input_EmailAddressLocator, sEmailAddress);

        return this;

    }

    //type password
    private HomePage typePassword(String sPassword){

        type(input_PasswordLocator, sPassword);

        return this;

    }

    //click on Login button
    private HomePage clickOnLoginButton(){

        click(button_LoginLocator);

        return new HomePage();

    }

    //click on Forgot password link
    private ForgotPasswordPage clickOnForgotPasswordLink(){

        click(link_ForgotPasswordLocator);

        return new ForgotPasswordPage();

    }

    //click on Start Here button
    private WriteAReviewPage clickOnStartHereButton(){

        click(button_StartHere());

        return new WriteAReviewPage();

    }

    //click on Single Review form
    private SingleReviewPage clickOnSingleReviewForm(){

        click(form_SingleReviewLocator);

        return new SingleReviewPage();

    }

    //click on Featured condition
    private TreatmentRatingsConditionPage clickOnFeaturedCondition(){

        click(link_FeaturedConditionLocator);

        return new TreatmentRatingsConditionPage();

    }

    //click on Get Started button
    private ConditionSelectionPage clickOnGetStartedButton(){

        click(button_GetStartedLocator);

        return new ConditionSelectionPage();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //Home page offers the user the service of being able to "log into"
    public HomePage loginAs(String sEmailAddress, String sPassword){

        return typeEmailAddress(sEmailAddress)
                .typePassword(sPassword)
                .clickOnLoginButton();

    }

    //go to Forgot Password page
    public ForgotPasswordPage goToForgotPasswordPage(){

        return clickOnForgotPasswordLink();

    }

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){

        return clickOnStartHereButton();

    }

    //go to Single Review page
    public SingleReviewPage goToSingleReviewPage(){

        return clickOnSingleReviewForm();

    }

    //go to Treatment Ratings Condition page
    public TreatmentRatingsConditionPage goToTreatmentRatingsConditionPage(){

        return clickOnFeaturedCondition();

    }

    //go to Condition Selection page
    public ConditionSelectionPage goToConditionSelectionPage(){

        return clickOnGetStartedButton();

    }

    //get Featured Condition url
    public String getFeaturedConditionUrl(){

        return waitFor(link_FeaturedConditionLocator, visible).getAttribute("href");

    }

    //get Get Started button url
    public String getGetStartedButtonUrl(){

        return waitFor(button_GetStartedLocator, visible).getAttribute("href");

    }

    //</editor-fold>

}
