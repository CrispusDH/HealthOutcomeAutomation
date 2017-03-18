package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static utility.Configuration.CoreConstants.WAIT_TIMEOUT;
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


}
