package pageObjectsActions;


import org.openqa.selenium.WebDriver;
import pageObjectsElements.BlogPageElements;

import java.util.concurrent.TimeUnit;

public class BlogPageActions {

    //click on Start Here button
    public static void clickOnStartHereButton(WebDriver driver){

        BlogPageElements.button_StartHere(driver).click();


    }

    //go to Detailed Blog page
    public static void clickOnSpecificBlog(WebDriver driver){

        BlogPageElements.blogs(driver).get(1).click();

    }
}
