package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class TestimonialsPage extends BaseClass {
    private WebElement element;
    private List<WebElement> elements;

    public TestimonialsPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Testimonials page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By cardsLocator = By.cssSelector(".body-content");

    //find all cards on a page
    private List<WebElement> cards(){

        return findElements(driver, cardsLocator, 5000);

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

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Testimonials", "url").equals(driver.getCurrentUrl()));

        return this;

    }

    //check that cards are on that page
    public TestimonialsPage checkIsBodyEmpty(){

        Assert.assertTrue(!cards().isEmpty());

        return this;

    }

    //</editor-fold>

}
