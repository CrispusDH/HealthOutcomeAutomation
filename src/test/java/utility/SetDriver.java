package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.File;
import java.io.IOException;


//need to be refactored
public class SetDriver {

    private static ChromeDriverService service;
    private static WebDriver driver;

    //Old variant of set up chrome driver
   /* public static void setChromeDriver(){

        try {
            System.setProperty("webdriver.chrome.driver", ReadXMLFile.takeConstantFromXML("ChromeDriver", "ChromeDriver", "path"));
        } catch (UnreachableBrowserException e) {
            System.out.println("Try to set Property again");
            System.setProperty("webdriver.chrome.driver", ReadXMLFile.takeConstantFromXML("ChromeDriver", "ChromeDriver", "path"));
        }
    }*/

   //new variant that has not worked yet :)
    /*
    public static void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        driver.get(ReadXMLFile.takeConstantFromXML("URL", "Landing Page", "url"));
    }

    public static void createAndStartService() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(ReadXMLFile.takeConstantFromXML("ChromeDriver", "ChromeDriver", "path")))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
