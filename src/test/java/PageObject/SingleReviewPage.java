package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import utility.BaseClass;

import static utility.WaitConditionForWebElement.visible;

public class SingleReviewPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By div_ReviewInfoLocator = By.cssSelector(".review-info");

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check that div_ReviewInfo element is displayed
    public SingleReviewPage isReviewInfoOnPage(){

        Assert.assertTrue(waitFor(div_ReviewInfoLocator, visible).isDisplayed());

        return this;

    }

    //</editor-fold>

}
