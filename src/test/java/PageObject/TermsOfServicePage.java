package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class TermsOfServicePage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By paragraphsLocator = By.cssSelector(".post p");

    //find all paragraphs
    private List<WebElement> paragraphs(){

        return waitForElements(paragraphsLocator, allPresence);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

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

    //</editor-fold>

}
