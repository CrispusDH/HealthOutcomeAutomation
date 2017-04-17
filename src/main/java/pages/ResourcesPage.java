package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class ResourcesPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By resourcesLocator = By.cssSelector(".resource");

    //find all resources
    private List<WebElement> resources(){

        return waitForElements(resourcesLocator, allPresence);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Final methods">

    //check that Resources page is not empty
    public ResourcesPage checkIsBodyEmpty(){

        Assert.assertTrue(!resources().isEmpty());

        return this;

    }

    //check that Resources page has resources
    public ResourcesPage checkAmountOfResources(){

        Assert.assertTrue(resources().size() > 0);

        return this;

    }

    //check page url
    public ResourcesPage checkUrl(){

        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Resources", "url"), urlToBe);

        return this;

    }

    //</editor-fold>

}
