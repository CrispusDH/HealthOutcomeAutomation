package pages;

import components.Footer;
import components.Header;
import wrappers.BasePage;

import static waiters.WaitConditionForUrl.urlToBe;

public class TreatmentVideosPage extends BasePage {

    private Header header = new Header();
    private Footer footer = new Footer();

    //check URL
    public TreatmentVideosPage checkURL(){
        checkUrlToBe(TreatmentRatingsConditionPage.expectedVideosURL, urlToBe);
        return this;
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

}