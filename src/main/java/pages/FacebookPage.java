package pages;

import utility.BasePage;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;

public class FacebookPage extends BasePage {

    //check page url
    public FacebookPage checkUrl(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Facebook", "url" ), urlToBe);
        return this;
    }

}
