package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

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
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Terms of Service", "url"), urlToBe);
        return this;
    }

}