package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class DetailedBlogPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public DetailedBlogPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Detailed blog page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By button_StartHereLocator = By.cssSelector(".button-cta span");
    private By button_FindOutMoreLocator = By.cssSelector(".button-cta span");

    //Start Here button
    private WebElement button_StartHere(){

        elements = findElements(driver, button_StartHereLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("START HERE")));

        return element;
    }

    //Find Out More button
    private WebElement button_FindOutMore(){

        elements = findElements(driver, button_FindOutMoreLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("Find Out More")));

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on Start Here button
    private WriteAReviewPage clickOnStartHereButton(){

         button_StartHere().click();

         return new WriteAReviewPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //go to Write a Review Page
    public WriteAReviewPage goToWriteAReviewPage(){

        return clickOnStartHereButton();

    }

    //</editor-fold>

}
