package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class FAQPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By questionsLocator = By.cssSelector(".questions li");

    private List<WebElement> questions(){

        return waitForElements(questionsLocator, allPresence);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //</editor-fold>

    //<editor-fold desc="Public methods">

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

        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "FAQ", "url"), urlToBe);

        return this;

    }

    //</editor-fold>

}
