package PageObject;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class TreatmentVideosPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">



    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check URL
    public TreatmentVideosPage checkURL(){

        Assert.assertEquals(TreatmentRatingsConditionPage.expectedVideosURL, getURL());

        return this;

    }

    //</editor-fold>
}
