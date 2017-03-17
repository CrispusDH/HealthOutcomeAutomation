package PageObject;

import org.junit.Assert;
import utility.BaseClass;
import utility.ReadXMLFile;

public class FacebookPage extends BaseClass {

    //<editor-fold desc="Public methods">

    //check page url
    public FacebookPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Facebook", "url" ).equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
