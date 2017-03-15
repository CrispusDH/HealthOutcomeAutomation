package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {
    private WebElement element;
    private List<WebElement> elements;

    public HomePage(WebDriver driver){

        this.driver = driver;


    }

    //<editor-fold desc="Finding page Elements">

    // The Home page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By input_EmailAddressLocator = By.id("id_username");
    private By input_PasswordLocator = By.id("id_password");
    private By button_LoginLocator = By.tagName("button");
    private By button_GetStartedLocator = By.cssSelector(".hero-titles a");
    private By link_ForgotPasswordLocator = By.linkText("Forgot password?");
    private By button_StartHereLocator = By.cssSelector(".body-content .button-cta span");
    private By form_SingleReviewLocator = By.cssSelector(".review-info");
    private By li_FeaturedConditionLocator = By.cssSelector(".condition.left > .condition-link");

    //email address input field
    private WebElement input_EmailAddress(){

        return findElements(driver, input_EmailAddressLocator,5000).get(0);

    }

    //password input field
    private WebElement input_Password(){

        return findElements(driver, input_PasswordLocator,5000).get(0);

    }

    //login button
    private WebElement button_Login(){

        return findElements(driver, button_LoginLocator,5000).get(0);

    }

    //Get Started button
    private WebElement button_GetStarted(){

        return findElements(driver, button_GetStartedLocator,5000).get(0);

    }

    //forgot password link
    private WebElement link_ForgotPassword(){

        return findElements(driver, link_ForgotPasswordLocator,5000).get(0);

    }

    //Start Here button
    private WebElement button_StartHere(){

        elements = findElements(driver, button_StartHereLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("START HERE")));

        return element;
    }

    //Single Review form
    private WebElement form_SingleReview(){

        return findElements(driver, form_SingleReviewLocator,5000).get(0);

    }

    //left Condition
    private WebElement li_FeaturedCondition(){

        return findElements(driver, li_FeaturedConditionLocator,5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //type email address
    private HomePage typeEmailAddress(String sEmailAddress){

        input_EmailAddress().sendKeys(sEmailAddress);

        return this;

    }

    //type password
    private HomePage typePassword(String sPassword){

        input_Password().sendKeys(sPassword);

        return this;

    }

    //click on Login button
    private HomePage clickOnLoginButton(){

        button_Login().click();

        return new HomePage(driver);

    }

    //click on Forgot password link
    private ForgotPasswordPage clickOnForgotPasswordLink(){

        link_ForgotPassword().click();

        return new ForgotPasswordPage(driver);

    }

    //click on Start Here button
    private WriteAReviewPage clickOnStartHereButton(){

        button_StartHere().click();

        return new WriteAReviewPage(driver);

    }

    //click on Single Review form
    private SingleReviewPage clickOnSingleReviewForm(){

        form_SingleReview().click();

        return new SingleReviewPage(driver);

    }

    //click on Featured condition
    private TreatmentRatingsConditionPage clickOnFeaturedCondition(){

        li_FeaturedCondition().click();

        //wait 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new TreatmentRatingsConditionPage(driver);

    }

    //click on Get Started button
    private ConditionSelectionPage clickOnGetStartedButton(){

        button_GetStarted().click();

        return new ConditionSelectionPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //Home page offers the user the service of being able to "log into"
    public HomePage loginAs(String sEmailAddress, String sPassword){

        //type email address
        typeEmailAddress(sEmailAddress);

        //type password
        typePassword(sPassword);

        //click login button
        return clickOnLoginButton();

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

        return li_FeaturedCondition().getAttribute("href");

    }

    //get Get Started button url
    public String getGetStartedButtonUrl(){

        return button_GetStarted().getAttribute("href");

    }

    //</editor-fold>

}
