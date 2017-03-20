package PageObject;

import org.junit.Assert;
import utility.BaseClass;
import utility.ReadXMLFile;
import utility.WaitConditionForUrl;

import java.util.concurrent.TimeUnit;

import static utility.WaitConditionForUrl.urlToBe;

public class TwitterPage extends BaseClass {

    //<editor-fold desc="Public methods">

    //check page url
    public TwitterPage checkUrl(){

        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Twitter", "url" ), urlToBe);

        return this;

    }

    //</editor-fold>

}
