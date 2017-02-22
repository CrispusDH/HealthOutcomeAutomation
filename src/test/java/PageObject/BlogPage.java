package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;

import java.util.List;

public class BlogPage extends FindElementsNewMechanism{
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public BlogPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The blog page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By blogsLocator = By.cssSelector(".blog-roll li");
    private By button_StartHere = By.cssSelector(".button-cta span");
    private By button_FindOutMoreLocator = By.cssSelector(".button-cta span");

    //find all blogs on page
    public List<WebElement> blogs (){

        return findElements(driver, blogsLocator, 5000);

    }

    //Start Here button
    public WebElement button_StartHere (){

        elements = findElements(driver, button_StartHere, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals("START HERE")));

        return element;
    }

    //Find Out More button
    public WebElement button_FindOutMore (){

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

    //<editor-fold desc="Base actions with elements">

    //click on Start Here button
    public WriteAReviewPage clickOnStartHereButton(){

        button_StartHere().click();

        return new WriteAReviewPage(driver);

    }

    //click on Specific Blog
    public DetailedBlogPage clickOnSpecificBlog(Integer blogNumber){

        blogs().get(blogNumber);

        return new DetailedBlogPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">

    public WriteAReviewPage goToWriteAReviewPage (){

        return clickOnStartHereButton();

    }

    public DetailedBlogPage goToDetailedBlogPage(Integer blogNumber){

        return clickOnSpecificBlog(blogNumber);

    }

    //</editor-fold>

}