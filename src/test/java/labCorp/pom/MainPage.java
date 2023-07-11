package labCorp.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "(//a[.='Careers'])[1]")
    public WebElement careers_link;
}
