package PageObject;

import org.junit.Assert;
import utility.BaseClass;
import utility.ReadXMLFile;

public class ForgotPasswordConfirmationPage extends BaseClass {

    //<editor-fold desc="Public methods">

    public String getCurrentUrl(){

        return driver.getCurrentUrl();

    }

    //check page url
    public ForgotPasswordConfirmationPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "Forgot Password Confirm", "url").equals(getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
