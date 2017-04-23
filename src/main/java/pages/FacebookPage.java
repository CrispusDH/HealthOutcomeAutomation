package pages;

import wrappers.BasePage;

public class FacebookPage extends BasePage {

    //check page url
    public FacebookPage checkUrl(){
        checkUrlToBe("Facebook");
        return this;
    }

}
