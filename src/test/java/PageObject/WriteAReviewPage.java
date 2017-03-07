package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;

import java.util.List;

public class WriteAReviewPage extends BaseClass {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;

    public WriteAReviewPage(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Write a Review Confirmation page contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

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

    //group title name
    private WebElement text_GroupTitle(){

        return findElements(driver, text_GroupTitleLocator, 5000).get(0);

    }

    //find specific Body Area
    private WebElement li_InjuryBodyArea(String sInjuryBodyArea){

        elements = findElements(driver, li_InjuryBodyAreaLocator,5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(sInjuryBodyArea)));

        return element;
    }

    //find specific Condition
    private WebElement li_Condition(String sCondition){

        elements = findElements(driver, li_ConditionLocator,5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(sCondition)));

        return element;
    }

    //find male gender
    private WebElement li_GenderMale(){

        return findElements(driver, li_GenderMaleLocator,5000).get(0);

    }

    //find female gender
    private WebElement li_GenderFemale(){

        return findElements(driver, li_GenderFemaleLocator,5000).get(0);

    }

    //find 0 - 6 Months
    private WebElement li_SufferedTime0_6(){

        return findElements(driver, li_SufferedTime0_6Locator,5000).get(0);

    }

    //find 6 - 18 Months
    private WebElement li_SufferedTime6_18(){

        return findElements(driver, li_SufferedTime6_18Locator,5000).get(0);

    }

    //find 18+ Months
    private WebElement li_SufferedTime18_(){

        return findElements(driver, li_SufferedTime18_Locator,5000).get(0);

    }

    //find 0 - 4 hours
    private WebElement li_PhysicalActivity0_4(){

        return findElements(driver, li_PhysicalActivity0_4Locator,5000).get(0);

    }

    //find 4 - 8 hours
    private WebElement li_PhysicalActivity4_8(){

        return findElements(driver, li_PhysicalActivity4_8Locator,5000).get(0);

    }

    //find 8+ hours
    private WebElement li_PhysicalActivity8_(){

        return findElements(driver, li_PhysicalActivity8_Locator, 5000).get(0);

    }

    //is repeat Yes
    private WebElement li_isRepeatYes(){

        return findElements(driver, li_isRepeatYes_Locator, 5000).get(0);

    }

    //is repeat No
    private WebElement li_isRepeatNo(){

        return findElements(driver, li_isRepeatNo_Locator, 5000).get(0);

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on specific body area
    private WriteAReviewPage clickOnSpecificBodyArea(String sBodyArea){

        li_InjuryBodyArea(sBodyArea).click();

        return new WriteAReviewPage(driver);

    }

    //click on specific condition
    private WriteAReviewPage clickOnSpecificCondition(String sCondition){

        li_Condition(sCondition).click();

        return new WriteAReviewPage(driver);

    }

    //click on gender
    private WriteAReviewPage clickOnGender(String sGender){

        switch (sGender){

            case "Male":
                li_GenderMale().click();
                return new WriteAReviewPage(driver);

            case "Female":
                li_GenderFemale().click();
                return new WriteAReviewPage(driver);

        }

        return new WriteAReviewPage(driver);

    }

    //choose suffered time option
    private WriteAReviewPage chooseSufferedTimeOption(String sOption){

        switch (sOption){

            case "0 - 6 Months":
                li_SufferedTime0_6().click();
                return new WriteAReviewPage(driver);

            case "6 - 18 Months":
                li_SufferedTime6_18().click();
                return new WriteAReviewPage(driver);

            case "18+ Months":
                li_SufferedTime18_().click();
                return new WriteAReviewPage(driver);

        }

        return new WriteAReviewPage(driver);

    }

    //choose is this a repeat injury or condition
    private WriteAReviewPage chooseIsRepeatOption(String sOption){

        switch (sOption){

            case "Yes":
                li_isRepeatYes().click();
                return new WriteAReviewPage(driver);

            case "No":
                li_isRepeatNo().click();
                return new WriteAReviewPage(driver);

        }

        return new WriteAReviewPage(driver);

    }


    //choose level of physical activity
    private WriteAReviewPage choosePhysicalActivity(String sOption){

        switch (sOption){

            case "0 - 4 hours":
                li_PhysicalActivity0_4().click();
                return new WriteAReviewPage(driver);

            case "4 - 8 hours":
                li_PhysicalActivity4_8().click();
                return new WriteAReviewPage(driver);

            case "8+ hours":
                li_PhysicalActivity8_().click();
                return new WriteAReviewPage(driver);

        }

        return new WriteAReviewPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check page url
    public boolean checkUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Write a Review Page", "fromBlogPage" ).equals(driver.getCurrentUrl());

    }

    //get current url
    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //get group title
    public String getGroupTitle(){

        return text_GroupTitle().getText();

    }

    public void writeAReview(String sBodyArea, String sCondition, String sGender, String sSufferedTimeOption, String sPhysicalActivityOption, String sIsRepeatOption){

        clickOnSpecificBodyArea(sBodyArea)
                .clickOnSpecificCondition(sCondition)
                .clickOnGender(sGender)
                .chooseSufferedTimeOption(sSufferedTimeOption)
                .choosePhysicalActivity(sPhysicalActivityOption)
                .chooseIsRepeatOption(sIsRepeatOption);

    }

    //</editor-fold>

}
