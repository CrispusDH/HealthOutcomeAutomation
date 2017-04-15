package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class AboutUsPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By paragraphsLocator = By.cssSelector(".post p");

    //find all paragraphs on page
    private List<WebElement> paragraphs(){

        return waitForElements(paragraphsLocator, allPresence);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

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

    //</editor-fold>

}
