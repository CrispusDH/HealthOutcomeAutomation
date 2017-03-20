package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import static utility.Configuration.CoreConstants.WAIT_TIMEOUT;
import static utility.WaitConditionForUrl.urlToBe;
import static utility.WaitConditionForWebElement.enabled;
import static utility.WaitConditionForWebElement.visible;
import static utility.WebDriverProvider.getDriver;

//improve find elements mechanism
public abstract class BaseClass {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BaseClass(){

        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);

    }

    protected WebElement waitFor(By locator, WaitConditionForWebElement condition) {
        return wait.until(condition.getType().apply(locator));
    }

    protected List<WebElement> waitForElements(By locator, WaitConditionForWebElements condition){

        return wait.until(condition.getType().apply(locator));

    }

    protected void click(By locator) {
        click(locator, enabled);
    }

    protected void click(By locator, WaitConditionForWebElement condition) {
        waitFor(locator, condition).click();
    }

    protected void type(By locator, CharSequence text) {
        waitFor(locator, visible).sendKeys(text);
    }

    protected void click(WebElement webElement){

        webElement.click();

    }

    protected WebElement findElementByText(List<WebElement> webElements, String text){

        WebElement element;
        int i = 0;
        do {
            element = webElements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(text)));

        return element;

    }

    protected String getURL(){

        return driver.getCurrentUrl();

    }

    protected boolean checkUrlToBe(String sExpectedUrl, WaitConditionForUrl condition){

        return wait.until(condition.getType().apply(sExpectedUrl));

    }

    protected void moveToElementAndClickOnElement(WebElement moveToElement, WebElement clickOnElement){

        Actions builder = new Actions(driver);

        //scroll to element above
        builder.moveToElement(moveToElement);

        builder.click(clickOnElement);

        builder.build().perform();

    }

    protected void safeSwitchTab(){

        ArrayList<String> currentTab;
        int counter = 1;
        do {

            currentTab = new ArrayList<>(driver.getWindowHandles());

            //System.out.println(currentTab.size());

            counter++;

        } while ((currentTab.size() == 1) && (counter < 10));

        driver.switchTo().window(currentTab.get(1));

    }

}
