package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import java.util.List;

import static waiters.WaitConditions.allPresence;

public class TermsOfServicePage extends BasePage {

    private By paragraphsLocator = By.cssSelector(".post p");

    //find all paragraphs
    private List<WebElement> paragraphs(){
        return waitForElements(paragraphsLocator, allPresence);
    }

    //check that page has text
    public TermsOfServicePage checkAmountOfParagraphs(){
        Assert.assertTrue(paragraphs().size() > 50);
        return this;
    }

    //check page url
    public TermsOfServicePage checkUrl(){
        checkUrlToBe("Terms of Service");
        return this;
    }

}