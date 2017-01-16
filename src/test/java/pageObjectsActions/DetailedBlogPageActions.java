package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.BlogPageElements;

import java.util.concurrent.TimeUnit;

public class DetailedBlogPageActions {

    //click on Start Here button
    public static void clickOnStartHereButton(WebDriver driver){

        BlogPageElements.button_StartHere(driver).click();

    }

}
