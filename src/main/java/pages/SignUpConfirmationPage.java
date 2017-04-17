package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class SignUpConfirmationPage extends BaseClass {

    private Header header = new Header();
    private Footer footer = new Footer();

    //<editor-fold desc="Finding page Elements">

    private By button_WriteAReviewOrFindTreatmentsLocator = By.cssSelector(".action");

    //find Write a review or Find Treatments button
    private WebElement button_WriteAReviewOrFindTreatments(String sButtonName){

        return findElementByText(waitForElements(button_WriteAReviewOrFindTreatmentsLocator, allPresence), sButtonName);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //check page url
    public SignUpConfirmationPage checkUrl(){

        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "SignUp Confirmation Page", "url"), urlToBe);

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

    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
