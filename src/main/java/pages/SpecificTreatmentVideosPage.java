package pages;

import wrappers.BasePage;

import static waiters.WaitConditionForUrl.urlToBe;

public class SpecificTreatmentVideosPage extends BasePage {

    //check URL
    public SpecificTreatmentVideosPage checkURL(){
        checkUrlToBe(SpecificTreatmentReviewsPage.expectedSpecificTreatmentVideosPageURL, urlToBe);
        return this;
    }

}