package pages;

import utility.BasePage;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;

public class FacebookPage extends BasePage {

    //check page url
    public FacebookPage checkUrl(){
        checkUrlToBe("Facebook");
        return this;
    }

}
