package pageObjectsActions;

import org.openqa.selenium.WebDriver;
import pageObjectsElements.SignUpPageElements;
import utility.RandomNumber;
import utility.ReadXMLFile;


public class SignUpPageActions {

    //fill all input fields and click on Join Now button
    public static void SignUp_Execute(WebDriver driver, String sPassword){

        //type email address
        SignUpPageElements.input_EmailAddress(driver).sendKeys((RandomNumber.createRandomNumber(Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "minRandomValue")), Integer.valueOf(ReadXMLFile.takeConstantFromXML("RandomNumberSet", "Main", "maxRandomValue"))) + "@gmail.com"));

        //type password
        SignUpPageElements.input_Password(driver).sendKeys(sPassword);

        //click on Join Now button
        SignUpPageElements.button_JoinNow(driver).click();
    }
}
