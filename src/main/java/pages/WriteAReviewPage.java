package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.BasePage;
import enums.WriteAReviewEnums.*;

import static enums.WriteAReviewEnums.GenderOptions.*;
import static enums.WriteAReviewEnums.PhysicalActivityOptions.*;
import static enums.WriteAReviewEnums.RepeatOptions.*;
import static enums.WriteAReviewEnums.SufferedOptions.*;
import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;
import static waiters.WaitConditions.allPresence;
import static waiters.WaitConditions.visible;

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
    private WriteAReviewPage clickOnGender(
            final GenderOptions genderOptions,
            final int currentStep){
        return Match(genderOptions).of(
                Case($(MALE),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                WriteAReviewPage.class)),
                Case($(FEMALE),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                WriteAReviewPage.class))
        );
    }

    private WriteAReviewPage clickOnSuffered(
            final SufferedOptions sufferedOptions,
            final int currentStep
    ){
        return Match(sufferedOptions).of(
                Case($(ZERO_TO_SIX),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                WriteAReviewPage.class)),
                Case($(SIX_TO_EIGHTEEN),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                WriteAReviewPage.class)),
                Case($(MORE_EIGHTEEN),
                        () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                WriteAReviewPage.class))
        );
    }

    //click on repeat
    private WriteAReviewPage clickOnRepeat(
            final RepeatOptions repeatOptions,
            final int currentStep
    ){
        return Match(repeatOptions).of(
                Case($(YES),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                WriteAReviewPage.class)),
                Case($(NO),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                WriteAReviewPage.class))
        );
    }

    //choose level of physical activity
    private WriteAReviewPage clickOnPhysicalActivity(
            final PhysicalActivityOptions physicalActivityOptions,
            final int currentStep
    ) {
        return Match(physicalActivityOptions).of(
                Case($(ZERO_TO_FOUR),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                WriteAReviewPage.class)),
                Case($(FOUR_TO_EIGHT),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                WriteAReviewPage.class)),
                Case($(MORE_EIGHT),
                        () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                WriteAReviewPage.class))
        );
    }

    //check page url from Blog page
    public WriteAReviewPage checkURLFromBlogPage(){
        checkUrlToBe("Write a Review Page from Blog page");
        return this;
    }

    //check page url from Detailed Blog page
    public WriteAReviewPage checkURLFromDetailedBlogPage(){
        checkUrlToBe("Write a Review Page from Detailed Blog page");
        return this;
    }

    //check Write a Review page URL from Treatment Ratings Condition
    public WriteAReviewPage checkURLFromTreatmentRatingsCondition(){
        checkUrlToBe("Write a Review page from Treatment Ratings Condition");
        return this;
    }

    //check Write a Review page URL from Treatment Reviews
    public WriteAReviewPage checkURLFromTreatmentsReviews(){
        checkUrlToBe("Write a Review page from Treatment Reviews");
        return this;
    }

    //check group title in case of navigation to Write a Review page from Treatment Reviews page
    public WriteAReviewPage checkGroupTitleInCaseOfFromTreatmentReviewsPage(){
        Assert.assertEquals("What is your gender?", ((WebElement) waitFor(text_GroupTitleLocator, visible)).getText());
        return this;
    }

    public WriteAReviewConfirmationPage writeAReview(
            String sBodyArea,
            String sCondition,
            final GenderOptions genderOptions,
            final SufferedOptions sufferedOptions,
            final PhysicalActivityOptions physicalActivityOptions,
            final RepeatOptions repeatOptions
    )
    {
        return clickOnSpecificBodyArea(sBodyArea)
                .clickOnSpecificCondition(sCondition)
                .clickOnGender(genderOptions, 3)
                .clickOnSuffered(sufferedOptions,4)
                .clickOnPhysicalActivity(physicalActivityOptions,5)
                .clickOnRepeat(repeatOptions,6)
                .clickOnSuffered(sufferedOptions, 7)
                .clickOnRepeat(repeatOptions,8)
                .clickOnNextButton(9)
                .clickOnNextButton(10)
                .clickOnNextButton(11)
                .clickOnNextButton(12)
                .clickOnNextButton(13)
                .clickOnNextButton(14)
                .clickOnNextButton(15)
                .clickOnPostReviewButton(16);
    }

}