package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForWebElements.allPresence;

public class TestimonialsPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By cardsLocator = By.cssSelector(".body-content");

    //find all cards on a page
    private List<WebElement> cards(){

        return waitForElements(cardsLocator, allPresence);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check the same in another way
    public TestimonialsPage checkAmountOfCards(){

        Assert.assertTrue(cards().size() > 0);

        return this;

    }

    //check page url
    public TestimonialsPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Testimonials", "url").equals(getURL()));

        return this;

    }

    //check that cards are on that page
    public TestimonialsPage checkIsBodyEmpty(){

        Assert.assertTrue(!cards().isEmpty());

        return this;

    }

    //</editor-fold>

}
