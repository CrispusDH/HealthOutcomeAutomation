package PageObject;

import org.junit.Assert;
import utility.BaseClass;
import utility.ReadXMLFile;

public class FirstStepOfCoachingProgramPage extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    //</editor-fold>

    //<editor-fold desc="Private methods">



    //</editor-fold>

    //<editor-fold desc="Public methods">

    //check page url
    public FirstStepOfCoachingProgramPage checkUrl(){

        Assert.assertTrue(ReadXMLFile.takeConstantFromXML("URL", "First Step Of Coaching Program", "url" ).equals(driver.getCurrentUrl()));

        return this;

    }

    //</editor-fold>

}
