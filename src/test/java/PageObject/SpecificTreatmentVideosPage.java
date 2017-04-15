package PageObject;

import org.junit.Assert;
import utility.BaseClass;

import static utility.WaitConditionForUrl.urlToBe;

public class SpecificTreatmentVideosPage extends BaseClass {


    //<editor-fold desc="Public methods">

    //check URL
    public SpecificTreatmentVideosPage checkURL(){

        checkUrlToBe(SpecificTreatmentReviewsPage.expectedSpecificTreatmentVideosPageURL, urlToBe);

        return this;

    }

    //</editor-fold>
}
