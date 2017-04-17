package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

import static utility.BaseTest.getDriver;

public class CustomExpectedCondition {

    public static ExpectedCondition<List<WebElement>> moreThanOne(
            final By locator) {
        return driver -> {
            List<WebElement> elements = getDriver().findElements(locator);
            return elements.size() > 1 ? elements : null;
        };

    }

}

