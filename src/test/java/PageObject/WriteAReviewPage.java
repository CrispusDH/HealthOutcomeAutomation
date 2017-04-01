package PageObject;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import static utility.WaitConditionForWebElement.visible;
import static utility.WaitConditionForWebElements.allPresence;

public class WriteAReviewPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By button_Next(final int currentStep){
        return By.cssSelector("div.review-form.body-content > div > div > div > div > div:nth-child(" + currentStep + ") > section > div.buttons > button");
    }
    private By button_PostReview(final int currentStep){
        return By.cssSelector("div.review-form.body-content > div > div > div > div > div:nth-child(" + currentStep + ") > section > div.buttons > button");
    }
    private By text_GroupTitleLocator = By.cssSelector(".group-title");
    private By li_InjuryBodyAreaLocator = By.cssSelector(".parts-list li");
    private By li_ConditionLocator = By.cssSelector(".conditions ul li");
    private By li_GenderMaleLocator = By.cssSelector(".form-content > div > div > div:nth-child(3) > section > div > ul > li.option-1");
    private By li_GenderFemaleLocator = By.cssSelector(".form-content > div > div > div:nth-child(3) > section > div > ul > li.option-2");
    private By li_SufferedTime0_6Locator = By.cssSelector(".form-content > div > div > div:nth-child(4) > section > div > ul > li.option-1");
    private By li_SufferedTime6_18Locator = By.cssSelector(".form-content > div > div > div:nth-child(4) > section > div > ul > li.option-2");
    private By li_SufferedTime18_Locator = By.cssSelector(".form-content > div > div > div:nth-child(4) > section > div > ul > li.option-3");
    private By li_PhysicalActivity0_4Locator = By.cssSelector(".form-content > div > div > div:nth-child(5) > section > div > ul > li.option-1");
    private By li_PhysicalActivity4_8Locator = By.cssSelector(".form-content > div > div > div:nth-child(5) > section > div > ul > li.option-2");
    private By li_PhysicalActivity8_Locator = By.cssSelector(".form-content > div > div > div:nth-child(5) > section > div > ul > li.option-3");
    private By li_isRepeatYes_Locator = By.cssSelector(".form-content > div > div > div:nth-child(6) > section > div > ul > li.option-1");
    private By li_isRepeatNo_Locator = By.cssSelector(".form-content > div > div > div:nth-child(6) > section > div > ul > li.option-2");

    //find specific Body Area
    private WebElement li_InjuryBodyArea(String sInjuryBodyArea){

        return findElementByText(waitForElements(li_InjuryBodyAreaLocator, allPresence), sInjuryBodyArea);

    }

    //find specific Condition
    private WebElement li_Condition(String sCondition){

        return findElementByText(waitForElements(li_ConditionLocator, allPresence), sCondition);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on Next button
    private WriteAReviewPage clickOnNextButton(final int currentStep){

        click(button_Next(currentStep));

        return new WriteAReviewPage();

    }

    //click on Post Review button
    private WriteAReviewConfirmationPage clickOnPostReviewButton(final int currentStep){

        click(button_PostReview(currentStep));

        return new WriteAReviewConfirmationPage();

    }

    //click on specific body area
    private WriteAReviewPage clickOnSpecificBodyArea(String sBodyArea){

        click(li_InjuryBodyArea(sBodyArea));

        return new WriteAReviewPage();

    }

    //click on specific condition
    private WriteAReviewPage clickOnSpecificCondition(String sCondition){

        click(li_Condition(sCondition));

        return new WriteAReviewPage();

    }

    //click on gender
    private WriteAReviewPage clickOnGender(String sGender){

        switch (sGender){

            case "Male":
                click(li_GenderMaleLocator);
                return new WriteAReviewPage();

            case "Female":
                click(li_GenderFemaleLocator);
                return new WriteAReviewPage();

        }

        return new WriteAReviewPage();

    }

    //choose suffered time option
    private WriteAReviewPage chooseSufferedTimeOption(String sOption){

        switch (sOption){

            case "0 - 6 Months":
                click(li_SufferedTime0_6Locator);
                return new WriteAReviewPage();

            case "6 - 18 Months":
                click(li_SufferedTime6_18Locator);
                return new WriteAReviewPage();

            case "18+ Months":
                click(li_SufferedTime18_Locator);
                return new WriteAReviewPage();

        }

        return new WriteAReviewPage();

    }

    //choose is this a repeat injury or condition
    private WriteAReviewPage chooseIsRepeatOption(String sOption){

        switch (sOption){

            case "Yes":
                click(li_isRepeatYes_Locator);
                return new WriteAReviewPage();

            case "No":
                click(li_isRepeatNo_Locator);
                return new WriteAReviewPage();

        }

        return new WriteAReviewPage();

    }


    //choose level of physical activity
    private WriteAReviewPage choosePhysicalActivity(String sOption){

        switch (sOption){

            case "0 - 4 hours":
                click(li_PhysicalActivity0_4Locator);
                return new WriteAReviewPage();

            case "4 - 8 hours":
                click(li_PhysicalActivity4_8Locator);
                return new WriteAReviewPage();

            case "8+ hours":
                click(li_PhysicalActivity8_Locator);
                return new WriteAReviewPage();

        }

        return new WriteAReviewPage();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check page url
    public WriteAReviewPage checkURLBasic(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Write a Review Page", "fromBlogPage" ).equals(getURL()));

        return this;

    }

    //check Write a Review page URL from Treatment Ratings Condition
    public WriteAReviewPage checkURLFromTreatmentRatingsCondition(){

        Assert.assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Ratings Condition", "url"), getURL());

        return this;

    }

    //check Write a Review page URL from Treatment Reviews
    public WriteAReviewPage checkURLFromTreatmentsReviews(){

        Assert.assertEquals(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Reviews", "url"), getURL());

        return this;

    }

    //check group title in case of navigation to Write a Review page from Treatment Reviews page
    public WriteAReviewPage checkGroupTitleInCaseOfFromTreatmentReviewsPage(){

        Assert.assertEquals("What is your gender?", waitFor(text_GroupTitleLocator, visible).getText());

        return this;

    }


    public WriteAReviewConfirmationPage writeAReview(String sBodyArea, String sCondition, String sGender, String sSufferedTimeOption, String sPhysicalActivityOption, String sIsRepeatOption){

        return clickOnSpecificBodyArea(sBodyArea)
                .clickOnSpecificCondition(sCondition)
                .clickOnGender(sGender)
                .chooseSufferedTimeOption(sSufferedTimeOption)
                .choosePhysicalActivity(sPhysicalActivityOption)
                .chooseIsRepeatOption(sIsRepeatOption)
                .clickOnNextButton(7)
                .clickOnNextButton(8)
                .clickOnNextButton(9)
                .clickOnNextButton(10)
                .clickOnNextButton(11)
                .clickOnNextButton(12)
                .clickOnNextButton(13)
                .clickOnPostReviewButton(14);

    }

    //</editor-fold>

}
