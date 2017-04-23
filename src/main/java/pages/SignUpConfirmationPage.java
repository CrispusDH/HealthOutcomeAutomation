package pages;

import components.Footer;
import components.Header;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;
import utility.ReadXMLFile;

import static waiters.WaitConditions.allPresence;

public class SignUpConfirmationPage extends BasePage {

    private Header header = new Header();
    private Footer footer = new Footer();

    private By button_WriteAReviewOrFindTreatmentsLocator = By.cssSelector(".action");

    //find Write a review or Find Treatments button
    private WebElement button_WriteAReviewOrFindTreatments(String sButtonName){
        return findElementByText(waitForElements(button_WriteAReviewOrFindTreatmentsLocator, allPresence), sButtonName);
    }

    //check page url
    public SignUpConfirmationPage checkUrl(){
        checkUrlToBe("SignUp Confirmation Page");
        return this;
    }

    //check that Treatments button is displayed on page
    public SignUpConfirmationPage checkIsTreatmentsButtonDisplayed(){
        Assert.assertTrue(button_WriteAReviewOrFindTreatments(ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed());
        return this;
    }

    //check that Write a Review button is displayed on page
    public SignUpConfirmationPage checkIsWriteAReviewButtonDisplayed(){
        Assert.assertTrue(button_WriteAReviewOrFindTreatments(ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed());
        return this;
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

}
