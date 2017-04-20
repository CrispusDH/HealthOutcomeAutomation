package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.ReadXMLFile;

import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class FAQPage extends BasePage {

    private By questionsLocator = By.cssSelector(".questions li");

    private List<WebElement> questions(){
        return waitForElements(questionsLocator, allPresence);
    }

    //check that FAQ are not empty
    public FAQPage checkIsBodyEmpty(){
        Assert.assertTrue(!questions().isEmpty());
        return this;
    }

    //check that FAQ page has paragraphs
    public FAQPage checkAmountOfQustions(){
        Assert.assertTrue(questions().size() > 0);
        return this;
    }

    //check page url
    public FAQPage checkUrl(){
        checkUrlToBe("FAQ");
        return this;
    }

}
