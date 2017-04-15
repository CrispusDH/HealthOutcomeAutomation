package PageObject;

import org.openqa.selenium.By;
import static javaslang.API.*;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReadXMLFile;
import java.util.List;

import static utility.WaitConditions.allPresence;

public class Footer extends BaseClass {

    //<editor-fold desc="Finding page Elements">

    private By  link_FooterLinksLocator = By.cssSelector(".links li");
    private By  link_FooterCopyrightsLocator = By.cssSelector(".copyright a");
    private By  link_ConnectLocator = By.cssSelector(".connect li a");

    //find all footer links
    private WebElement link_FooterLink(String sFooterLinkName){

        return findElementByText(waitForElements(link_FooterLinksLocator, allPresence), sFooterLinkName);

    }

    //find all items in copyrights block
    private WebElement link_FooterCopyrights(String sFooterCopyrightName){

        return findElementByText(waitForElements(link_FooterCopyrightsLocator, allPresence), sFooterCopyrightName);

    }

    //facebook, twitter, linkedin, mailto links
    private WebElement link_Connect(String sName){

        List<WebElement> elements =  waitForElements(link_ConnectLocator, allPresence);

        return Match(sName).of(
                Case("facebook", elements.get(0)),
                Case("twitter", elements.get(1)),
                Case("linkedin", elements.get(2)),
                Case("mail", elements.get(3))
        );

    }

    //</editor-fold>

    //<editor-fold desc="Private methods">

    //click on About link
    private AboutUsPage clickOnAboutLink(){

        link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "About", "linkName")).click();

        return new AboutUsPage();

    }

    //click on FAQ link
    private FAQPage clickOnFAQLink(){

        click(link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "FAQ", "linkName")));

        return new FAQPage();

    }

    //click on Blog link
    private BlogPage clickOnBlogLink(){

        click(link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Blog", "linkName")));

        return new BlogPage();

    }

    //click on Resources link
    private ResourcesPage clickOnResourcesLink(){

        click(link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Resources", "linkName")));

        return new ResourcesPage();

    }

    //click on Testimonials link
    private TestimonialsPage clickOnTestimonialsLink(){

        click(link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Testimonials", "linkName")));

        return new TestimonialsPage();

    }

    //click on Contact Us link
    private ContactUsPage clickOnContactUsLink(){

        click(link_FooterLink(ReadXMLFile.takeConstantFromXML("FooterLink", "Contact Us", "linkName")));

        return new ContactUsPage();

    }

    //click on Privacy Policy link
    private PrivacyPolicyPage clickOnPrivacyPolicyLink(){

        click(link_FooterCopyrights(ReadXMLFile.takeConstantFromXML("FooterCopyright", "Privacy Policy", "copyrightName")));

        return new PrivacyPolicyPage();

    }

    //click on Terms of Service link
    private TermsOfServicePage clickOnTermsOfServiceLink(){

        click(link_FooterCopyrights(ReadXMLFile.takeConstantFromXML("FooterCopyright", "Terms of Service", "copyrightName")));

        return new TermsOfServicePage();

    }

    //get 'href' attribute from linkedin link
    private String getLinkValueFromLinkedinLink(){

        return link_Connect("linkedin").getAttribute("href");

    }

    //get 'href' attribute from mail link
    private String getLinkValueFromMailLink(){

        return link_Connect("mail").getAttribute("href");

    }

    //click on facebook link and switch to a new Window
    private FacebookPage clickOnFacebookLink(){

        click(link_Connect("facebook"));

        safeSwitchTab();

        return new FacebookPage();

    }

    //click on twitter link and switch to a new window
    private TwitterPage clickOnTwitterLink(){

        click(link_Connect("twitter"));

        safeSwitchTab();

        return new TwitterPage();

    }

    //</editor-fold>

    //<editor-fold desc="Public methods">

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
    //check Linkedin href
    public boolean checkLinkedingUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Linkedin", "href" ).equals(getLinkValueFromLinkedinLink());

    }

    //check mail href
    public boolean checkMailUrl(){

        return ReadXMLFile.takeConstantFromXML("URL", "Mail", "href" ).equals(getLinkValueFromMailLink());

    }

    //</editor-fold>

}
