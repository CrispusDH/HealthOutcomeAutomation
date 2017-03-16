package PageObject;

import lombok.val;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseClass;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForWebElement.visible;
import static utility.WaitConditionForWebElements.allVisible;

public class BlogPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    // The blog page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By blogsLocator = By.cssSelector(".blog-roll li");
    private By button_StartHere = By.cssSelector(".button-cta span");
    private By button_FindOutMoreLocator = By.cssSelector(".button-cta span");

    //find all blogs on page
    private List<WebElement> blogs(){

        return waitForElements(blogsLocator, allVisible);

    }

    //Start Here button
    private WebElement button_StartHere(){

        return findElementByText(waitForElements(button_StartHere, allVisible), "START HERE");

    }

    //Find Out More button
    private WebElement button_FindOutMore(){

        return findElementByText(waitForElements(button_FindOutMoreLocator, allVisible), "Find Out More");

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on Start Here button
    private WriteAReviewPage clickOnStartHereButton(){

        click(button_StartHere());

        return new WriteAReviewPage();

    }

    //click on Specific Blog
    private DetailedBlogPage clickOnSpecificBlog(Integer blogNumber){

        blogs().get(blogNumber);

        return new DetailedBlogPage();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    public WriteAReviewPage goToWriteAReviewPage (){

        return clickOnStartHereButton();

    }

    public DetailedBlogPage goToDetailedBlogPage(Integer blogNumber){

        return clickOnSpecificBlog(blogNumber);

    }

    //check that Blog page body are not empty
    public BlogPage checkIsBodyEmpty(){

        Assert.assertTrue(!blogs().isEmpty());

        return this;

    }

    //check that Blog page has paragraphs
    public BlogPage checkAmountOfBlogs(){

        Assert.assertTrue(blogs().size() > 2);

        return this;

    }

    //check page url
    public BlogPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Blog", "url").equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
