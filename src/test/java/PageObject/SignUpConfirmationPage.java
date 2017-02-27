package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;
import utility.ReadXMLFile;

import java.util.List;

public class SignUpConfirmationPage extends FindElementsNewMechanism{
    private final WebDriver driver;
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
    public WebElement button_WriteAReviewOrFindTreatments(String sButtonName){

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

    //<editor-fold desc="Base actions with elements">

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "SignUp Confirmation Page", "url").equals(driver.getCurrentUrl());

    }

    //check that Treatments button is displayed on page
    public boolean checkTreatmentsButtonIsDisplayed(){

        return button_WriteAReviewOrFindTreatments(ReadXMLFile.takeConstantFromXML("ButtonName", "FindTreatments", "name")).isDisplayed();

    }

    //check that Write a Review button is displayed on page
    public boolean checkWriteAReviewButtonIsDisplayed(){

        return button_WriteAReviewOrFindTreatments(ReadXMLFile.takeConstantFromXML("ButtonName", "WriteAReview", "name")).isDisplayed();

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
