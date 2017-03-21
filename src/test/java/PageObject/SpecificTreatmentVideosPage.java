package PageObject;

import org.junit.Assert;
import utility.BaseClass;

import java.util.List;

public class SpecificTreatmentVideosPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check URL
    public SpecificTreatmentVideosPage checkURL(){

        Assert.assertEquals(SpecificTreatmentReviewsPage.expectedSpecificTreatmentVideosPageURL, getURL());

        return this;

    }

    //</editor-fold>
}
