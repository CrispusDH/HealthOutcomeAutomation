package wrappers;

import enums.ConditionTabsEnum;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SpecificTreatmentVideosPage;
import pages.TreatmentRatingsConditionPage;
import pages.TreatmentReviewsPage;
import pages.TreatmentVideosPage;
import ru.yandex.qatools.allure.annotations.Step;
import utility.ReadXMLFile;
import waiters.WaitConditionForUrl;
import waiters.WaitConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static enums.ConditionTabsEnum.*;
import static javaslang.API.*;
import static org.joor.Reflect.on;
import static utility.Configuration.CoreConstants.WAIT_TIMEOUT;
import static waiters.WaitConditionForUrl.urlToBe;
import static waiters.WaitConditions.*;

public abstract class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(){
        this.driver = BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    @Step("Wait for {0} locator using {1} condition")
    @SuppressWarnings("unchecked")
    protected <T> T waitFor(By locator, WaitConditions condition) {
        return (T) wait.until(condition.getType().apply(locator));
    }

    @Step("Wait for {0} locator using {1} condition")
    @SuppressWarnings("unchecked")
    protected <T> T waitForElements(By locator, WaitConditions condition){
        return (T) wait.until(condition.getType().apply(locator));
    }

    @Step("Click on {0} locator using enabled condition")
    protected void click(By locator) {
        click(locator, enabled);
    }

    @Step("Click on {0} locator using {1} condition")
    protected void click(By locator, WaitConditions condition) {
        ((WebElement) waitFor(locator, condition)).click();
    }

    @Step("Type in {0} locator the {1} text")
    protected void type(By locator, CharSequence text) {
        ((WebElement) waitFor(locator, visible)).sendKeys(text);
    }

    @Step("Click on {0} webElement")
    protected void click(WebElement webElement){
        webElement.click();
    }

    @Step("Find element by {1} text")
    protected WebElement findElementByText(List<WebElement> webElements, String text) {
        return webElements
                .stream()
                .filter(webElement -> Objects.equals(webElement.getText(), text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(webElements.size() + " size, text - " + text));
    }

    @Step("Get URL")
    protected String getURL(){
        return this.driver.getCurrentUrl();
    }

    @Step("Check URL")
    protected boolean checkUrlToBe(String sExpectedUrl, WaitConditionForUrl condition){
        return wait.until(condition.getType().apply(sExpectedUrl));
    }

    @Step("Check URL for {0} page")
    protected boolean checkUrlToBe(String sPageName){
        return checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", sPageName, "url"), urlToBe);
    }

    protected void scrollUp(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(250, 0)");
    }

    protected void safeSwitchTab(){
        ArrayList<String> currentTab;
        int counter = 1;
        do {
            currentTab = new ArrayList<>(driver.getWindowHandles());
            //System.out.println(currentTab.size());
            counter++;
        } while ((currentTab.size() == 1) && (counter < 30));
        driver.switchTo().window(currentTab.get(1));
    }

    //find tab web element
    private WebElement tab(ConditionTabsEnum conditionTabsEnum, By tabLocator){
        return findElementByText(waitForElements(tabLocator, allPresence), conditionTabsEnum.getsConditionName());
    }

    //click on tab and return specific Page class
    private <T extends BasePage> T selectTab(ConditionTabsEnum conditionTabsEnum, By tabLocator, Class<T> pageClass){
        tab(conditionTabsEnum, tabLocator).click();
        return on(pageClass).create().get();
    }

    @Step("Click on {0} locator")
    protected <T extends BasePage> T clickOnOption(By by, Class<T> pageClass){
        click((WebElement) waitFor(by, enabled));
        return on(pageClass).create().get();
    }

    //return specific (T) Page class using tabLocator and Matching by condition tabs enum value
    @Step("Click on {0} tab, by {1} locator")
    @SuppressWarnings("unchecked")
    protected <T extends BasePage> T clickOnSpecificTab(ConditionTabsEnum conditionTabsEnum, By tabLocator){
        return (T) Match(conditionTabsEnum).of(
                Case($(TREATMENT_RATINGS), n -> selectTab(n, tabLocator, TreatmentRatingsConditionPage.class)),
                Case($(TREATMENT_REVIEWS), n -> selectTab(n, tabLocator, TreatmentReviewsPage.class)),
                Case($(VIDEOS_AND_GUIDES), n -> selectTab(n, tabLocator, TreatmentVideosPage.class)),
                Case($(SPECIFIC_TREATMENT_VIDEOS_AND_GUIDES), n -> selectTab(n, tabLocator, SpecificTreatmentVideosPage.class))
        );
    }

}