package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;

public class BlogPage extends BasePage {

    private By blogsLocator = By.cssSelector(".blog-roll li");
    private By button_StartHereLocator = By.cssSelector(".button-cta span");
    private By button_FindOutMoreLocator = By.cssSelector(".button-cta span");

    //find all blogs on page
    private List<WebElement> blogs(){
        return waitForElements(blogsLocator, allPresence);
    }

    //Start Here button
    private WebElement button_StartHere(){
        return findElementByText(waitForElements(button_StartHereLocator, allPresence), "START HERE");
    }

    //Find Out More button
    private WebElement button_FindOutMore(){
        return findElementByText(waitForElements(button_FindOutMoreLocator, allPresence), "Find Out More");
    }

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
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Blog", "url"), urlToBe);
        return this;
    }

}
