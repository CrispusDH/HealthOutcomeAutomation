package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utility.Configuration.CoreConstants.WAIT_TIMEOUT;
import static utility.WaitConditions.*;
import static utility.WebDriverProvider.getDriver;

public abstract class BaseClass {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BaseClass(){

        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);

    }

    @SuppressWarnings("unchecked")
    protected <T> T waitFor(By locator, WaitConditions condition) {
        return (T) wait.until(condition.getType().apply(locator));
    }

    @SuppressWarnings("unchecked")
    protected <T> T waitForElements(By locator, WaitConditions condition){
        return (T) wait.until(condition.getType().apply(locator));
    }

    protected void click(By locator) {
        click(locator, enabled);
    }

    protected void click(By locator, WaitConditions condition) {
        ((WebElement) waitFor(locator, condition)).click();
    }

    protected void type(By locator, CharSequence text) {
        ((WebElement) waitFor(locator, visible)).sendKeys(text);
    }

    protected void click(WebElement webElement){

        webElement.click();

    }

    protected WebElement findElementByText(List<WebElement> webElements, String text) {
        return webElements
                .stream()
                .filter(webElement -> Objects.equals(webElement.getText(), text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(webElements.size() + " size, text - " + text));
    }

    protected String getURL(){

        return this.driver.getCurrentUrl();

    }

    protected boolean checkUrlToBe(String sExpectedUrl, WaitConditionForUrl condition){

        return wait.until(condition.getType().apply(sExpectedUrl));

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

}
