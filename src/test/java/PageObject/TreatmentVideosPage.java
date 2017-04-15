package PageObject;

import utility.BaseClass;

import static utility.WaitConditionForUrl.urlToBe;

public class TreatmentVideosPage extends BaseClass {

    private final Header header = new Header();
    private final Footer footer = new Footer();

    //<editor-fold desc="Public methods">

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

    //</editor-fold>
}
