package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.FooterElements;

import java.util.concurrent.TimeUnit;

public class FooterActions {

    //go to About, FDQ, Blog, Resources, Testimonials, Contact Us pages
    public static void clickOnFooterLink(WebDriver driver, String FooterLinkName){

        FooterElements.link_FooterLink(driver, FooterLinkName).click();

    }

    //go to Privacy Policy and Terms of Service pages
    public static void clickOnFooterCopyright(WebDriver driver, String FooterCopyrightName){

        FooterElements.link_FooterCopyrights(driver, FooterCopyrightName).click();

    }

    //go to facebook or twitter pages or check links for linkedin and email
    public static void clickOnFootterConnect(WebDriver driver, String name){

        FooterElements.link_Connect(driver, name).click();

        //wait 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
