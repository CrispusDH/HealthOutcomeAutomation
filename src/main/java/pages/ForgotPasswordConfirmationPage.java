package pages;

import utility.BaseClass;
import utility.ReadXMLFile;

import static utility.WaitConditionForUrl.urlToBe;

public class ForgotPasswordConfirmationPage extends BaseClass {

    //<editor-fold desc="Public methods">

    //check page url
    public ForgotPasswordConfirmationPage checkUrl(){

        checkUrlToBe(ReadXMLFile.takeConstantFromXML("URL", "Forgot Password Confirm", "url"), urlToBe);

        return this;

    }

    //</editor-fold>

}
