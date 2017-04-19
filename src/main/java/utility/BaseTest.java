package utility;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static java.util.Optional.ofNullable;

public abstract class BaseTest {

    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
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

    protected HomePage openHomePage(){
        getDriver().get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));
        return new HomePage();
    }

}