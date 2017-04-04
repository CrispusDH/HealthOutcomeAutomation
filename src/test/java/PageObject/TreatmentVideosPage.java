package PageObject;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class TreatmentVideosPage extends BaseClass {

    private final Header header = new Header();
    private final Footer footer = new Footer();

    //<editor-fold desc="Public methods">

    //check URL
    public TreatmentVideosPage checkURL(){

        Assert.assertEquals(TreatmentRatingsConditionPage.expectedVideosURL, getURL());

        return this;

    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    //</editor-fold>
}
