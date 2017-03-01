package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;

import java.util.List;

public class SpecificTreatmentVideosPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public SpecificTreatmentVideosPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">



    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //get current url
    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">



    //</editor-fold>
}
