package pages;

import wrappers.BasePage;

public class TwitterPage extends BasePage {

    //check page url
    public TwitterPage checkUrl(){
        checkUrlToBe("Twitter");
        return this;
    }

}