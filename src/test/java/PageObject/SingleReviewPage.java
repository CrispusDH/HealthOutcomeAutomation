package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import static utility.WaitConditions.visible;

public class SingleReviewPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By div_ReviewInfoLocator = By.cssSelector(".review-info");

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check that div_ReviewInfo element is displayed
    public SingleReviewPage isReviewInfoOnPage(){

        Assert.assertTrue(((WebElement) waitFor(div_ReviewInfoLocator, visible)).isDisplayed());

        return this;

    }

    //</editor-fold>

}
