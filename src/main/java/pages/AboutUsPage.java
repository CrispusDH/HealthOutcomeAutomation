package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class AboutUsPage extends BasePage {

    private By paragraphsLocator = By.cssSelector(".post p");

    //find all paragraphs on page
    private List<WebElement> paragraphs(){
        return waitForElements(paragraphsLocator, allPresence);
    }

    //check page url
    public AboutUsPage checkUrl(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "About Us", "url"), urlToBe);
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
