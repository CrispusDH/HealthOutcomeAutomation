package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class WriteAReviewPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public WriteAReviewPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Write a Review Confirmation page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By text_GroupTitleLocator = By.cssSelector(".group-title");

    //group title name
    private WebElement text_GroupTitle(){

        return findElements(driver, text_GroupTitleLocator, 5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Write a Review Page", "fromBlogPage" ).equals(driver.getCurrentUrl());

    }

    //get current url
    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //get group title
    public String getGroupTitle(){

        return text_GroupTitle().getText();

    }

    //</editor-fold>

}
