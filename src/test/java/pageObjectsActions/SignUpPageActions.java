package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.SignUpPageElements;
import utility.RandomNumber;
import utility.ReadXMLFile;


public class SignUpPageActions {

    public static void SignUp_Execute(WebDriver driver, String sPassword){
        SignUpPageElements.input_EmailAddress(driver).sendKeys((RandomNumber.createRandomNumber(Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "minRandomValue")), Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "maxRandomValue"))) + "@gmail.com"));
        SignUpPageElements.input_Password(driver).sendKeys(sPassword);
        SignUpPageElements.button_JoinNow(driver).click();
    }
}
