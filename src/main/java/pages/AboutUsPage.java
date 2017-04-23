package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import java.util.List;

import static waiters.WaitConditions.allPresence;

public class AboutUsPage extends BasePage {

    private By paragraphsLocator = By.cssSelector(".post p");

    //find all paragraphs on page
    private List<WebElement> paragraphs(){
        return waitForElements(paragraphsLocator, allPresence);
    }

    //check page url
    public AboutUsPage checkUrl(){
        checkUrlToBe("About Us");
        return this;
    }

    //check that About Us page has paragraphs
    public AboutUsPage checkAmountOfParagraphs(){
        Assert.assertTrue(paragraphs().size() > 0);
        return this;
    }

    //check that AboutUS body are not empty
    public AboutUsPage checkIsEmpty(){
        Assert.assertTrue(!paragraphs().isEmpty());
        return this;
    }

}
