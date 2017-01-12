package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.FooterElements;

import java.util.concurrent.TimeUnit;

public class FooterActions {

    public static void clickOnFooterLink(WebDriver driver, String FooterLinkName){

        FooterElements.lnk_FooterLink(driver, FooterLinkName).click();

    }

    public static void clickOnFooterCopyright(WebDriver driver, String FooterCopyrightName){

        FooterElements.link_FooterCopyrights(driver, FooterCopyrightName).click();

    }

    public static void clickOnFootterConnect(WebDriver driver, String name){

        FooterElements.link_Connect(driver, name).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
