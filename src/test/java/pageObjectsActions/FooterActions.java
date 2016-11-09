package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.FooterElements;

public class FooterActions {

    public static void clickOnFooterLink(WebDriver driver, String FooterLinkName){
        FooterElements.lnk_FooterLink(driver, FooterLinkName).click();
    }
}
