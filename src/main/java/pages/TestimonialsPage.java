package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class TestimonialsPage extends BasePage {

    //<editor-fold desc="Finding page Elements">

    private By cardsLocator = By.cssSelector(".body-content");

    //find all cards on a page
    private List<WebElement> cards(){

        return waitForElements(cardsLocator, allPresence);

    }

    //check the same in another way
    public TestimonialsPage checkAmountOfCards(){
        Assert.assertTrue(cards().size() > 0);
        return this;
    }

    //check page url
    public TestimonialsPage checkUrl(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Testimonials", "url"), urlToBe);
        return this;
    }

    //check that cards are on that page
    public TestimonialsPage checkIsBodyEmpty(){
        Assert.assertTrue(!cards().isEmpty());
        return this;
    }

}