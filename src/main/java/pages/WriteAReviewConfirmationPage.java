package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import static utility.WaitConditions.allPresence;
import static utility.WaitConditions.visible;

public class WriteAReviewConfirmationPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By form_SignUpLocator = By.cssSelector(".signup-static");
    private By txt_ReviewUserNameLocator = By.cssSelector(".review-user .user-name");

    //find Review user name text field
    private WebElement txt_ReviewUserName (String sUserName){

        return findElementByText(waitForElements(txt_ReviewUserNameLocator, allPresence), sUserName);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    public void isSignUpFormVisible(){

        Assert.assertTrue(((WebElement) waitFor(form_SignUpLocator, visible)).isDisplayed());

    }

    //</editor-fold>

}
