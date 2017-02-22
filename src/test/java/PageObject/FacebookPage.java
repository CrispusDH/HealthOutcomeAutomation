package PageObject;


import org.openqa.selenium.WebDriver;
import utility.FindElementsNewMechanism;

public class FacebookPage extends FindElementsNewMechanism{
    private final WebDriver driver;

    public FacebookPage(WebDriver driver){

        this.driver = driver;

    }

}
