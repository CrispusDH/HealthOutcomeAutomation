package pages;

import org.openqa.selenium.By;
import utility.BaseClass;
import utility.ReadXMLFile;
import utility.WriteAReviewEnum.*;

import static utility.WaitConditionForUrl.urlToBe;
import static utility.WriteAReviewEnum.GenderOptions.MALE;

public class FirstStepOfCoachingProgramPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By commonOptionLocator(final int currentStep, final int chooseOption){

        return By.cssSelector(".form-wrapper > div > div > div > div:nth-child(" + currentStep + ") > section > div > ul > li.option-" + chooseOption + "");

    }

    private By commonButtonLocator(final int currentStep){

        return By.cssSelector(".form-wrapper > div > div > div > div:nth-child("+ currentStep + ") > section > div.buttons > button");

    }


    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on gender
    private FirstStepOfCoachingProgramPage clickOnGender(final GenderOptions genderOptions, final int currentStep){

        switch (genderOptions){

            case MALE:
                click(commonOptionLocator(currentStep, 1));
                return new FirstStepOfCoachingProgramPage();

            case FEMALE:
                click(commonOptionLocator(currentStep, 2));
                return new FirstStepOfCoachingProgramPage();

        }

        return new FirstStepOfCoachingProgramPage();

    }

    //click on age
    private FirstStepOfCoachingProgramPage clickOnAge(String sAge, final int currentStep){

        switch (sAge){

            case "< 18":
                click(commonOptionLocator(currentStep, 1));
                return new FirstStepOfCoachingProgramPage();

            case "18-34":
                click(commonOptionLocator(currentStep, 2));
                return new FirstStepOfCoachingProgramPage();

            case "35-54":
                click(commonOptionLocator(currentStep, 3));
                return new FirstStepOfCoachingProgramPage();

            case "55+":
                click(commonOptionLocator(currentStep, 4));
                return new FirstStepOfCoachingProgramPage();

        }

        return new FirstStepOfCoachingProgramPage();

    }

    //click on Physical Activity
    private FirstStepOfCoachingProgramPage clickOnPhysicalActivity(String sLevel, final int currentStep){

        switch (sLevel){

            case "0-4":
                click(commonOptionLocator(currentStep, 1));
                return new FirstStepOfCoachingProgramPage();

            case "4-8":
                click(commonOptionLocator(currentStep, 2));
                return new FirstStepOfCoachingProgramPage();

            case "8+":
                click(commonOptionLocator(currentStep, 3));
                return new FirstStepOfCoachingProgramPage();

        }

        return new FirstStepOfCoachingProgramPage();

    }

    //click on Status
    private FirstStepOfCoachingProgramPage clickOnStatus(String sStatus, final int currentStep) {

        switch (sStatus) {

            case "In Pain":
                click(commonOptionLocator(currentStep, 1));
                return new FirstStepOfCoachingProgramPage();

            case "Recovering":
                click(commonOptionLocator(currentStep, 2));
                return new FirstStepOfCoachingProgramPage();

            case "Cured":
                click(commonOptionLocator(currentStep, 3));
                return new FirstStepOfCoachingProgramPage();

        }

        return new FirstStepOfCoachingProgramPage();
    }

        //click on Status
    private FirstStepOfCoachingProgramPage clickOnPainInterfere(String sPainInterfere, final int currentStep){

        switch (sPainInterfere){

            case "Not at all":
                click(commonOptionLocator(currentStep, 1));
                return new FirstStepOfCoachingProgramPage();

            case "A little bit":
                click(commonOptionLocator(currentStep, 2));
                return new FirstStepOfCoachingProgramPage();

            case "Somewhat":
                click(commonOptionLocator(currentStep, 3));
                return new FirstStepOfCoachingProgramPage();

            case "Quite a bit":
                click(commonOptionLocator(currentStep, 4));
                return new FirstStepOfCoachingProgramPage();

            case "All the time":
                click(commonOptionLocator(currentStep, 5));
                return new FirstStepOfCoachingProgramPage();

        }

        return new FirstStepOfCoachingProgramPage();

    }

    //click on how long have you suffered
    private FirstStepOfCoachingProgramPage clickOnSuffered(String sSuffered, final int currentStep) {

        switch (sSuffered) {

            case "0-6":
                click(commonOptionLocator(currentStep, 1));
                return new FirstStepOfCoachingProgramPage();

            case "6-18":
                click(commonOptionLocator(currentStep, 2));
                return new FirstStepOfCoachingProgramPage();

            case "18+":
                click(commonOptionLocator(currentStep, 3));
                return new FirstStepOfCoachingProgramPage();

        }

        return new FirstStepOfCoachingProgramPage();
    }

    //click on repeat
    private FirstStepOfCoachingProgramPage clickOnRepeat(String sRepeat, final int currentStep) {

        switch (sRepeat) {

            case "Yes":
                click(commonOptionLocator(currentStep, 1));
                return new FirstStepOfCoachingProgramPage();

            case "No":
                click(commonOptionLocator(currentStep, 2));
                return new FirstStepOfCoachingProgramPage();

        }

        return new FirstStepOfCoachingProgramPage();
    }

    private FirstStepOfCoachingProgramPage clickOnNextButton(final int currentStep){

        click(commonButtonLocator(currentStep));

        return new FirstStepOfCoachingProgramPage();

    }

    private CreateAPrivateAccount clickOnNextButtonLast(final int currentStep){

        click(commonButtonLocator(currentStep));

        return new CreateAPrivateAccount();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check page url
    public FirstStepOfCoachingProgramPage checkUrl(){

        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "First Step Of Coaching Program", "url" ), urlToBe);

        return this;

    }

    public CreateAPrivateAccount writeAReview(){

        return clickOnGender(MALE, 1)
                .clickOnAge("18-34", 2)
                .clickOnPhysicalActivity("4-8", 3)
                .clickOnStatus("Cured", 4)
                .clickOnPainInterfere("Somewhat", 5)
                .clickOnSuffered("6-18", 6)
                .clickOnRepeat("Yes", 7)
                .clickOnNextButton(8)
                .clickOnNextButton(9)
                .clickOnNextButton(10)
                .clickOnNextButton(11)
                .clickOnNextButton(12)
                .clickOnNextButton(13)
                .clickOnNextButtonLast(14);

    }

    //</editor-fold>

}
