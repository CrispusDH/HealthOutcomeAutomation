package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import static utility.WaitConditionForWebElements.allPresence;

public class DetailedBlogPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By button_StartHereLocator = By.cssSelector(".button-cta span");
    private By button_FindOutMoreLocator = By.cssSelector(".button-cta span");

    //Start Here button
    private WebElement button_StartHere(){

        return findElementByText(waitForElements(button_StartHereLocator, allPresence), "START HERE");
    }

    //Find Out More button
    private WebElement button_FindOutMore(){

        return findElementByText(waitForElements(button_FindOutMoreLocator, allPresence), "Find Out More");

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on Start Here button
    private WriteAReviewPage clickOnStartHereButton(){

         click(button_StartHere());

         return new WriteAReviewPage();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //go to Write a Review Page
    public WriteAReviewPage goToWriteAReviewPage(){

        return clickOnStartHereButton();

    }

    //</editor-fold>

}
