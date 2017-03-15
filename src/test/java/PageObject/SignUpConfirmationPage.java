package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class SignUpConfirmationPage extends BaseClass {
    private WebElement element;
    private List<WebElement> elements;

    public SignUpConfirmationPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The SignUp Confirmation page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By button_WriteAReviewOrFindTreatmentsLocator = By.cssSelector(".action");

    //find Write a review or Find Treatments button
    private WebElement button_WriteAReviewOrFindTreatments(String sButtonName){

        elements = findElements(driver, button_WriteAReviewOrFindTreatmentsLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            i++;
        } while (!(element.getText().equals(sButtonName)));
        //System.out.println(element.getText());

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //check page url
    public SignUpConfirmationPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "SignUp Confirmation Page", "url").equals(driver.getCurrentUrl()));

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

    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
