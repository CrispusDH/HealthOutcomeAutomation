package wrappers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import utility.ReadXMLFile;
import utility.RetryRule;

import static java.util.Optional.ofNullable;

public abstract class BaseTest {

    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
    }


    protected HomePage openHomePage(){
        getDriver().get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));
        return new HomePage();
    }

    @Before
    public void setupDriver() {
        ChromeDriverManager.getInstance().setup();
        DRIVER_CONTAINER.set(new ChromeDriver());
    }

    @After
    public void cleanUp() {
        ofNullable(getDriver()).ifPresent(WebDriver::quit);
        DRIVER_CONTAINER.remove();
    }

    //Timeout Rule that applies to all test cases in the test class
    @Rule
    public Timeout globalTimeout = Timeout.seconds(300);

    //Rerun failed tests 3 times
    @Rule
    public RetryRule retryRule = new RetryRule(3);

}