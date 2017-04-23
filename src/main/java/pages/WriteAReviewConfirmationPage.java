package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import static waiters.WaitConditions.allPresence;
import static waiters.WaitConditions.visible;

public class WriteAReviewConfirmationPage extends BasePage {

    private By form_SignUpLocator = By.cssSelector(".signup-static");
    private By txt_ReviewUserNameLocator = By.cssSelector(".review-user .user-name");

    //find Review user name text field
    private WebElement txt_ReviewUserName (String sUserName){
        return findElementByText(waitForElements(txt_ReviewUserNameLocator, allPresence), sUserName);
    }

    public void isSignUpFormVisible(){
        Assert.assertTrue(((WebElement) waitFor(form_SignUpLocator, visible)).isDisplayed());
    }

}