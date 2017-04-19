package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;

import static utility.WaitConditions.visible;

public class SingleReviewPage extends BasePage {

    private By div_ReviewInfoLocator = By.cssSelector(".review-info");

    //check that div_ReviewInfo element is displayed
    public SingleReviewPage isReviewInfoOnPage(){
        Assert.assertTrue(((WebElement) waitFor(div_ReviewInfoLocator, visible)).isDisplayed());
        return this;
    }

}