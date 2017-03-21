package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

import static utility.WaitConditionForWebElements.allPresence;

public class PrivacyPolicyPage extends BaseClass {

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
    public PrivacyPolicyPage checkAmountOfParagraphs(){

        Assert.assertTrue(paragraphs().size() > 10);

        return this;

    }

    //check page url
    public PrivacyPolicyPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Privacy Policy", "url").equals(getURL()));

        return this;

    }

    //</editor-fold>

}
