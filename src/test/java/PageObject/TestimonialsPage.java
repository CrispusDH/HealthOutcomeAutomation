package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;
import utility.ReadXMLFile;

import java.util.List;

public class TestimonialsPage extends FindElementsNewMechanism{
    private final WebDriver driver;
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
    public List<WebElement> cards (){

        return findElements(driver, cardsLocator, 5000);

    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //check that cards are on that page
    public boolean bodyIsEmpty(){

        return cards().isEmpty();

    }

    //check the same in another way
    public boolean checkAmountOfCards(){

        return cards().size() > 0;

    }

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Testimonials", "url").equals(driver.getCurrentUrl());

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">



    //</editor-fold>

}
