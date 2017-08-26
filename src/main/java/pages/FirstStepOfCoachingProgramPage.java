package pages;

import enums.WriteAReviewEnums.*;
import org.openqa.selenium.By;
import wrappers.BasePage;

import static enums.WriteAReviewEnums.AgeOptions.*;
import static enums.WriteAReviewEnums.GenderOptions.*;
import static enums.WriteAReviewEnums.PainInterfereOptions.*;
import static enums.WriteAReviewEnums.PainLevelOptions.*;
import static enums.WriteAReviewEnums.PhysicalActivityOptions.*;
import static enums.WriteAReviewEnums.RepeatOptions.*;
import static enums.WriteAReviewEnums.StatusOptions.*;
import static enums.WriteAReviewEnums.SufferedOptions.*;
import static javaslang.API.*;

public class FirstStepOfCoachingProgramPage extends BasePage {

    private By commonOptionLocator(final int currentStep, final int chooseOption){
        return By.cssSelector(".form-wrapper > div > div > div > div:nth-child(" + currentStep + ") > section > div > ul > li.option-" + chooseOption + "");
    }

    private By commonButtonLocator(final int currentStep){
        return By.cssSelector(".form-wrapper > div > div > div > div:nth-child("+ currentStep + ") > section > div.buttons > button");
    }

    private By nextButtonForLastScreen() {
        return By.cssSelector(".submit-buttons > button");
    }

    private FirstStepOfCoachingProgramPage clickOnGender(
            final GenderOptions genderOptions,
            final int currentStep){
        return Match(genderOptions).of(
                Case($(MALE),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(FEMALE),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                FirstStepOfCoachingProgramPage.class))
        );
    }

    private FirstStepOfCoachingProgramPage clickOnAge(
            final AgeOptions ageOptions,
            final int currentStep
    ){
        return Match(ageOptions).of(
                Case($(LESS_EIGHTEEN),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(EIGHTEEN_TO_THIRTY_FOUR),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(THIRTY_FIVE_TO_FIFTY_FOUR),
                        () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(MORE_FIFTY_FIVE),
                        () -> clickOnOption(commonOptionLocator(currentStep, 4),
                                FirstStepOfCoachingProgramPage.class))
        );
    }

    private FirstStepOfCoachingProgramPage clickOnPhysicalActivity(
            final PhysicalActivityOptions physicalActivityOptions,
            final int currentStep
    ) {
                return Match(physicalActivityOptions).of(
                Case($(ZERO_TO_FOUR),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(FOUR_TO_EIGHT),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(MORE_EIGHT),
                        () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                FirstStepOfCoachingProgramPage.class))
        );
    }

    private FirstStepOfCoachingProgramPage clickOnStatus(
            final StatusOptions statusOptions,
            final int currentStep
    ){
                return Match(statusOptions).of(
                        Case($(IN_PAIN),
                                () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                        FirstStepOfCoachingProgramPage.class)),
                        Case($(RECOVERING),
                                () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                        FirstStepOfCoachingProgramPage.class)),
                        Case($(CURED),
                                () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                        FirstStepOfCoachingProgramPage.class))
                );
    }

    //click on Pain Interfere
    private FirstStepOfCoachingProgramPage clickOnPainInterfere(
            final PainInterfereOptions painInterfereOptions,
            final int currentStep
    ){
        return Match(painInterfereOptions).of(
                Case($(NOT_AT_ALL),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(A_LITTLE_BIT),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(SOMEWHAT),
                        () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(QUITE_A_BIT),
                        () -> clickOnOption(commonOptionLocator(currentStep, 4),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(ALL_THE_TIME),
                        () -> clickOnOption(commonOptionLocator(currentStep, 5),
                                FirstStepOfCoachingProgramPage.class))
        );
    }

    //click on Pain Level
    private FirstStepOfCoachingProgramPage clickOnPainLevel(
            final PainLevelOptions painLevelOptions,
            final int currentStep
    ){
        return Match(painLevelOptions).of(
                Case($(NO_PAIN),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(MILD),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(DISCOMFORTING),
                        () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(DISTRESSING),
                        () -> clickOnOption(commonOptionLocator(currentStep, 4),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(HORRIBLE),
                        () -> clickOnOption(commonOptionLocator(currentStep, 5),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(EXCRUCIATING),
                        () -> clickOnOption(commonOptionLocator(currentStep, 6),
                                FirstStepOfCoachingProgramPage.class))
        );
    }

    //click on how long have you suffered
    private FirstStepOfCoachingProgramPage clickOnSuffered(
            final SufferedOptions sufferedOptions,
            final int currentStep
    ){
        return Match(sufferedOptions).of(
                Case($(ZERO_TO_SIX),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(SIX_TO_EIGHTEEN),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(MORE_EIGHTEEN),
                        () -> clickOnOption(commonOptionLocator(currentStep, 3),
                                FirstStepOfCoachingProgramPage.class))
        );
    }

    //click on repeat
    private FirstStepOfCoachingProgramPage clickOnRepeat(
            final RepeatOptions repeatOptions,
            final int currentStep
    ){
        return Match(repeatOptions).of(
                Case($(YES),
                        () -> clickOnOption(commonOptionLocator(currentStep, 1),
                                FirstStepOfCoachingProgramPage.class)),
                Case($(NO),
                        () -> clickOnOption(commonOptionLocator(currentStep, 2),
                                FirstStepOfCoachingProgramPage.class))
        );
    }

    private FirstStepOfCoachingProgramPage clickOnNextButton(final int currentStep){
        click(commonButtonLocator(currentStep));
        return new FirstStepOfCoachingProgramPage();
    }

    private CreateAPrivateAccount clickOnNextButtonLast(){
        click(nextButtonForLastScreen());
        return new CreateAPrivateAccount();
    }

    //check page url
    public FirstStepOfCoachingProgramPage checkUrl(){
        checkUrlToBe("First Step Of Coaching Program");
        return this;
    }

    public CreateAPrivateAccount writeAReview(){
        return clickOnGender(MALE, 1)
                .clickOnAge(EIGHTEEN_TO_THIRTY_FOUR, 2)
                .clickOnPhysicalActivity(FOUR_TO_EIGHT, 3)
                .clickOnStatus(CURED, 4)
                .clickOnPainInterfere(SOMEWHAT, 5)
                .clickOnPainInterfere(SOMEWHAT, 6)
                .clickOnPainLevel(DISCOMFORTING, 7)
                .clickOnSuffered(SIX_TO_EIGHTEEN, 8)
                .clickOnRepeat(YES, 9)
                .clickOnRepeat(YES, 10)
                .clickOnNextButton(11)
                .clickOnNextButton(12)
                .clickOnNextButton(13)
                .clickOnNextButton(14)
                .clickOnNextButton(15)
                .clickOnNextButton(16)
                .clickOnNextButtonLast();
    }

}
