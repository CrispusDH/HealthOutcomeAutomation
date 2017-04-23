package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;

import java.util.List;

import static waiters.WaitConditions.allPresence;

public class ResourcesPage extends BasePage {

    private By resourcesLocator = By.cssSelector(".resource");

    //find all resources
    private List<WebElement> resources(){
        return waitForElements(resourcesLocator, allPresence);
    }

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
        checkUrlToBe("Resources");
        return this;
    }

}
