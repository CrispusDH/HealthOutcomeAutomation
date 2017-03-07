package utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//improve find elements mechanism
public abstract class BaseClass {

        protected List<WebElement> findElements(WebDriver webDriver, By by, int timeout) {

        int iSleepTime = 1000;

        for (int i = 0; i < timeout; i += iSleepTime) {

            List<WebElement> oWebElements = webDriver.findElements(by);

            if (oWebElements.size() > 0 && oWebElements.get(0).isDisplayed()) {

                return oWebElements;

            } else {

                try {
                    TimeUnit.MILLISECONDS.sleep(iSleepTime);

                    System.out.println(String.format("%s: Waited for %d milliseconds.[%s]", new java.util.Date().toString(), i + iSleepTime, by));

                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        // Can't find 'by' element. Therefore throw an exception.
        String sException = String.format("Can't find %s after %d milliseconds.", by, timeout);

        throw new RuntimeException(sException);
    }

}
