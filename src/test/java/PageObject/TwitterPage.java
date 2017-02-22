package PageObject;

import org.openqa.selenium.WebDriver;
import utility.FindElementsNewMechanism;

public class TwitterPage extends FindElementsNewMechanism {
    private final WebDriver driver;

    public TwitterPage(WebDriver driver){

        this.driver = driver;

    }
}
