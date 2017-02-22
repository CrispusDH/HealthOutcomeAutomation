package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElementsNewMechanism;
import utility.ReadXMLFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Footer extends FindElementsNewMechanism {
    private final WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;


    public Footer(WebDriver driver){

        this.driver = driver;

    }

    //<editor-fold desc="Finding page Elements">

    // The Footer contains several elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.

    private By  link_FooterLinksLocator = By.cssSelector(".links li");
    private By  link_FooterCopyrightsLocator = By.cssSelector(".copyright a");
    private By  link_ConnectLocator = By.cssSelector(".connect li a");

    //find all footer links
    public WebElement link_FooterLink(String footerLinkName){

        elements = findElements(driver, link_FooterLinksLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(footerLinkName)));

        return element;
    }

    //find all items in copyrights block
    public WebElement link_FooterCopyrights (String footerCopyrightName){

        elements = findElements(driver, link_FooterCopyrightsLocator, 5000);

        int i = 0;
        do {
            element = elements.get(i);
            //System.out.println(element.getText() + "\n");
            i++;
        } while (!(element.getText().equals(footerCopyrightName)));

        return element;
    }

    //facebook, twitter, linkedin, mailto links
    public WebElement link_Connect(String name){

        elements = findElements(driver, link_ConnectLocator, 5000);

        //System.out.println(elements.get(0).getTagName());
        switch (name){

            case "facebook":
                return element = elements.get(0);

            case "twitter":
                return element = elements.get(1);

            case "linkedin":
                return element = elements.get(2);

            case "mail":
                return element = elements.get(3);

        }

        return element;
    }

    //</editor-fold>

    //<editor-fold desc="Base actions with elements">

    //click on About link
    public AboutUsPage clickOnAboutLink(){

        link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "About", "linkName")).click();

        return new AboutUsPage(driver);

    }

    //click on FAQ link
    public FAQPage clickOnFAQLink(){

        link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "FAQ", "linkName")).click();

        return new FAQPage(driver);

    }

    //click on Blog link
    public BlogPage clickOnBlogLink(){

        link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Blog", "linkName")).click();

        return new BlogPage(driver);

    }

    //click on Resources link
    public ResourcesPage clickOnResourcesLink(){

        link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Resources", "linkName")).click();

        return new ResourcesPage(driver);

    }

    //click on Testimonials link
    public TestimonialsPage clickOnTestimonialsLink(){

        link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Testimonials", "linkName")).click();

        return new TestimonialsPage(driver);

    }

    //click on Contact Us link
    public ContactUsPage clickOnContactUsLink(){

        link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Contact Us", "linkName")).click();

        return new ContactUsPage(driver);

    }

    //click on Privacy Policy link
    public PrivacyPolicyPage clickOnPrivacyPolicyLink(){

        link_FooterCopyrights(ReadXMLFile.takeConstantFromXML("FooterCopyright", "Privacy Policy", "copyrightName")).click();

        return new PrivacyPolicyPage(driver);

    }

    //click on Terms of Service link
    public TermsOfServicePage clickOnTermsOfServiceLink(){

        link_FooterCopyrights(ReadXMLFile.takeConstantFromXML("FooterCopyright", "Terms of Service", "copyrightName")).click();

        return new TermsOfServicePage(driver);

    }

    //get 'href' attribute from linkedin link
    public String getLinkValueFromLinkedinLink(){

        return link_Connect("linkedin").getAttribute("href");

    }

    //get 'href' attribute from mail link
    public String getLinkValueFromMailLink(){

        return link_Connect("mail").getAttribute("href");

    }

    //click on facebook link and switch to a new Window
    public FacebookPage clickOnFacebookLink(){

        //click on Facebook link
        link_Connect("facebook").click();

        //wait 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //switch to new window
        ArrayList<String> currentTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(currentTab.get(1));

        return new FacebookPage(driver);

    }

    //click on twitter link and switch to a new window
    public TwitterPage clickOnTwitterLink(){

        //click on Twitter link
        link_Connect("twitter").click();

        //wait 3 seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //switch to new window
        ArrayList<String> currentTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(currentTab.get(1));

        return new TwitterPage(driver);

    }

    //</editor-fold>

    //<editor-fold desc="Final methods">

    //go to About Us page
    public AboutUsPage goToAboutUsPage(){

        return clickOnAboutLink();

    }

    //go to FAQ page
    public FAQPage goToFAQPage(){

        return clickOnFAQLink();

    }

    //go to Blog page
    public BlogPage goToBlogPage(){

        return clickOnBlogLink();

    }

    //go to Resources page
    public ResourcesPage goToResourcesPage(){

        return clickOnResourcesLink();

    }

    //go to Testimonials page
    public TestimonialsPage goToTestimonialsPage(){

        return clickOnTestimonialsLink();

    }

    //go to Contact Us page
    public ContactUsPage goToContactUsPage(){

        return clickOnContactUsLink();

    }

    //go to Privacy Policy page
    public PrivacyPolicyPage goToPrivacyPolicyPage(){

        return clickOnPrivacyPolicyLink();

    }

    //go to Terms of Service page
    public TermsOfServicePage goToTermsOfServicePage(){

        return clickOnTermsOfServiceLink();

    }

    //go to Facebook page
    public FacebookPage goToFacebookPage(){

        return clickOnFacebookLink();

    }

    //go to Twitter page
    public TwitterPage goToTwitterPage(){

        return clickOnTwitterLink();

    }

    //</editor-fold>

}