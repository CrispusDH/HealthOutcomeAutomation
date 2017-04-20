package pages;

import utility.BasePage;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;

public class TwitterPage extends BasePage {

    //check page url
    public TwitterPage checkUrl(){
        checkUrlToBe("Twitter");
        return this;
    }

}