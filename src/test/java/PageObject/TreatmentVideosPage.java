package PageObject;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class TreatmentVideosPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public TreatmentVideosPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">



    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check URL
    public TreatmentVideosPage checkURL(){

        Assert.assertEquals(TreatmentRatingsConditionPage.expectedVideosURL, driver.getCurrentUrl());

        return this;

    }



    //get current url
    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //</editor-fold>
}
