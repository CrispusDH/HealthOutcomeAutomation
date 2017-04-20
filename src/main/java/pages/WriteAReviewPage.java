package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BasePage;
import utility.ReadXMLFile;
import enums.WriteAReviewEnums.*;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditions.allPresence;
import static utility.WaitConditions.visible;

public class WriteAReviewPage extends BasePage {

    private By button_Next(final int currentStep){
        return By.cssSelector("div.review-form.body-content > div > div > div > div > div:nth-child(" + currentStep + ") > section > div.buttons > button");
    }
    private By button_PostReview(final int currentStep){
        return By.cssSelector("div.review-form.body-content > div > div > div > div > div:nth-child(" + currentStep + ") > section > div.buttons > button");
    }

    private By commonOptionLocator(final int currentStep, final int chooseOption){
        return By.cssSelector(".form-content > div > div > div:nth-child(" + currentStep + ") > section > div > ul > li.option-" + chooseOption + "");
    }

    private By text_GroupTitleLocator = By.cssSelector(".group-title");
    private By li_InjuryBodyAreaLocator = By.cssSelector(".parts-list li");
    private By li_ConditionLocator = By.cssSelector(".conditions ul li");

    //find specific Body Area
    private WebElement li_InjuryBodyArea(String sInjuryBodyArea){
        return findElementByText(waitForElements(li_InjuryBodyAreaLocator, allPresence), sInjuryBodyArea);
    }

    //find specific Condition
    private WebElement li_Condition(String sCondition){
        return findElementByText(waitForElements(li_ConditionLocator, allPresence), sCondition);
    }

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
    private WriteAReviewPage clickOnGender(final GenderOptions genderOptions, final int currentStep){
        switch (genderOptions){
            case MALE:
                click(commonOptionLocator(currentStep, 1));
                return new WriteAReviewPage();
            case FEMALE:
                click(commonOptionLocator(currentStep, 2));
                return new WriteAReviewPage();
        }
        return new WriteAReviewPage();
    }

    //choose suffered time option
    private WriteAReviewPage chooseSufferedTimeOption(String sOption, final int currentStep){
        switch (sOption){
            case "0 - 6 Months":
                click(commonOptionLocator(currentStep, 1));
                return new WriteAReviewPage();
            case "6 - 18 Months":
                click(commonOptionLocator(currentStep, 2));
                return new WriteAReviewPage();
            case "18+ Months":
                click(commonOptionLocator(currentStep, 3));
                return new WriteAReviewPage();
        }
        return new WriteAReviewPage();
    }

    //choose is this a repeat injury or condition
    private WriteAReviewPage chooseIsRepeatOption(String sOption, final int currentStep){
        switch (sOption){
            case "Yes":
                click(commonOptionLocator(currentStep, 1));
                return new WriteAReviewPage();
            case "No":
                click(commonOptionLocator(currentStep, 2));
                return new WriteAReviewPage();
        }
        return new WriteAReviewPage();
    }

    //choose level of physical activity
    private WriteAReviewPage choosePhysicalActivity(String sOption, final int currentStep){
        switch (sOption){
            case "0 - 4 hours":
                click(commonOptionLocator(currentStep, 1));
                return new WriteAReviewPage();
            case "4 - 8 hours":
                click(commonOptionLocator(currentStep, 2));
                return new WriteAReviewPage();
            case "8+ hours":
                click(commonOptionLocator(currentStep, 3));
                return new WriteAReviewPage();
        }
        return new WriteAReviewPage();
    }

    //check page url
    public WriteAReviewPage checkURLBasic(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Write a Review Page", "fromBlogPage" ), urlToBe);
        return this;
    }

    //check Write a Review page URL from Treatment Ratings Condition
    public WriteAReviewPage checkURLFromTreatmentRatingsCondition(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Ratings Condition", "url"), urlToBe);
        return this;
    }

    //check Write a Review page URL from Treatment Reviews
    public WriteAReviewPage checkURLFromTreatmentsReviews(){
        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Write a Review page from Treatment Reviews", "url"), urlToBe);
        return this;
    }

    //check group title in case of navigation to Write a Review page from Treatment Reviews page
    public WriteAReviewPage checkGroupTitleInCaseOfFromTreatmentReviewsPage(){
        Assert.assertEquals("What is your gender?", ((WebElement) waitFor(text_GroupTitleLocator, visible)).getText());
        return this;
    }

    public WriteAReviewConfirmationPage writeAReview(String sBodyArea, String sCondition, final GenderOptions genderOptions, String sSufferedTimeOption, String sPhysicalActivityOption, String sIsRepeatOption){
        return clickOnSpecificBodyArea(sBodyArea)
                .clickOnSpecificCondition(sCondition)
                .clickOnGender(genderOptions, 3)
                .chooseSufferedTimeOption(sSufferedTimeOption,4)
                .choosePhysicalActivity(sPhysicalActivityOption,5)
                .chooseIsRepeatOption(sIsRepeatOption,6)
                .clickOnNextButton(7)
                .clickOnNextButton(8)
                .clickOnNextButton(9)
                .clickOnNextButton(10)
                .clickOnNextButton(11)
                .clickOnNextButton(12)
                .clickOnNextButton(13)
                .clickOnPostReviewButton(14);
    }

}