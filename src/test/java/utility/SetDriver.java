package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class SetDriver {

    public static void setChromeDriver(){

        try {
            System.setProperty("webdriver.chrome.driver", ReadXMLFile.takeConstantFromXML("ChromeDriver", "ChromeDriver", "path"));
        } catch (UnreachableBrowserException e) {
            System.out.println("Try to set Property again");
            System.setProperty("webdriver.chrome.driver", ReadXMLFile.takeConstantFromXML("ChromeDriver", "ChromeDriver", "path"));
        }
    }
}
