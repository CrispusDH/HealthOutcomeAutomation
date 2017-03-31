package utility;

import PageObject.Footer;
import PageObject.Header;
import lombok.Getter;

@Getter
public abstract class HeaderFooter extends BaseClass {

    private  final Header header = new Header();
    private final Footer footer = new Footer();

}
