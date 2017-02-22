package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class TreatmentRatingsConditionPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public TreatmentRatingsConditionPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Treatment Ratings Condition page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By link_ChangeConditionLocator = By.cssSelector(".change-condition");
    private By button_LearnMoreLocator = By.cssSelector(".button-cta span");
    private By button_ShareYourExperienceLocator = By.cssSelector(".banner-cta .button-cta span");
    private By tabLocator = By.cssSelector(".hero-tabs li");
    private By li_TreatmentLocator = By.cssSelector(".treatment-link");

    //find Change condition link
    public WebElement link_ChangeCondition(){

        return findElements(driver, link_ChangeConditionLocator,5000).get(0);

    }

    //Learn More button
    public WebElement button_LearnMore (){

        elements = findElements(driver, button_LearnMoreLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("LEARN MORE   ")));

        return element;
    }

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
    public WebElement tab (String sTabName){

        elements = findElements(driver, tabLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(sTabName)));

        return element;
    }

    //find specific Treatment
    public WebElement li_Treatment(String sTreatmentName){

        elements = findElements(driver, li_TreatmentLocator,5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(sTreatmentName)));

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //click on Change Condition link
    public ConditionSelectionPage clickOnChangeConditionLink(){

        link_ChangeCondition().click();

        return new ConditionSelectionPage(driver);

    }

    //click on Lear More button
    public FirstStepOfCoachingProgramPage clickOnLearnMoreButton(){

        button_LearnMore().click();

        return new FirstStepOfCoachingProgramPage(driver);

    }

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

    //click on Specific Treatment block
    public SpecificTreatmentReviewsPage clickOnSpecificTreatment(String sTreatmentName){

        li_Treatment(sTreatmentName).click();

        return new SpecificTreatmentReviewsPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">

    //go to Condition Selection page
    public ConditionSelectionPage goToConditionSelectionPage(){

        return clickOnChangeConditionLink();

    }

    //go to 1st step of coaching program
    public FirstStepOfCoachingProgramPage goToFirstStepOfCoachingProgramPage(){

        return clickOnLearnMoreButton();

    }

    //go to Write a Review page
    public WriteAReviewPage goToWriteAReviewPage(){

        return clickOnShareYourExperienceButton();

    }

    //go into Specific Treatment
    public SpecificTreatmentReviewsPage goToSpecificTreatment(String sTreatmentName){

        return clickOnSpecificTreatment(sTreatmentName);

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
