package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class TreatmentReviewsPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public TreatmentReviewsPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Treatment Reviews page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By button_ShareYourExperienceLocator = By.cssSelector(".banner-cta .button-cta span");
    private By tabLocator = By.cssSelector(".hero-tabs li");

    //Share your experience button
    public WebElement button_ShareYourExperience (){

        elements = findElements(driver, button_ShareYourExperienceLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("SHARE YOUR EXPERIENCE")));

        return element;
    }

    //Find tab
    public WebElement tab (String tabName){

        elements = findElements(driver, tabLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(tabName)));

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //click on Share Your Experience button
    public WriteAReviewPage clickOnShareYourExperienceButton(){

        button_ShareYourExperience().click();

        return new WriteAReviewPage(driver);

    }

    //click on Specific tab
    public FindElementsNewMechanism clickOnSpecificTab(String sTabNames){

        switch (sTabNames) {

            case "Treatment Ratings":
                tab("TREATMENT RATINGS").click();
                return new TreatmentRatingsConditionPage(driver);

            case "Treatment Reviews":
                tab("TREATMENT REVIEWS").click();
                return new TreatmentReviewsPage(driver);

            case "Videos & Guides":
                tab("VIDEOS & GUIDES").click();
                return new TreatmentVideosPage(driver);
        }

        return null;

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){

        return clickOnShareYourExperienceButton();

    }

    //go to Treatment Ratings Condition page
    public TreatmentRatingsConditionPage goToTreatmentRatingsConditionPage(){

        return (TreatmentRatingsConditionPage) clickOnSpecificTab("Treatment Ratings");

    }

    //go to Treatment Reviews page
    public TreatmentReviewsPage goToTreatmentReviewsPage(){

        return (TreatmentReviewsPage) clickOnSpecificTab("Treatment Reviews");

    }

    //go to Treatment Videos & Guides page
    public TreatmentVideosPage goToTreatmentVideosPage(){

        return (TreatmentVideosPage) clickOnSpecificTab("Videos & Guides");

    }

    //</editor-fold>

}
