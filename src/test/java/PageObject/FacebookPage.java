package PageObject;

import org.junit.Assert;
import utility.BaseClass;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WebDriverProvider.getDriver;

public class FacebookPage extends BaseClass {

    //<editor-fold desc="Public methods">



    //check page url
    public FacebookPage checkUrl(){


        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Facebook", "url" ), urlToBe);

        return this;

    }



    //</editor-fold>

}
