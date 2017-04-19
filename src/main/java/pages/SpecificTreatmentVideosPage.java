package pages;

import utility.BasePage;

import static utility.WaitConditionForUrl.urlToBe;

public class SpecificTreatmentVideosPage extends BasePage {

    //check URL
    public SpecificTreatmentVideosPage checkURL(){
        checkUrlToBe(SpecificTreatmentReviewsPage.expectedSpecificTreatmentVideosPageURL, urlToBe);
        return this;
    }

}