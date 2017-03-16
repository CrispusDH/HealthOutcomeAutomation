package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utility.BaseClass;
import utility.ReadXMLFile;

public class TwitterPage extends BaseClass {

    //<editor-fold desc="Public methods">

    //check page url
    public TwitterPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Twitter", "url" ).equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
