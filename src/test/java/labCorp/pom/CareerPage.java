package labCorp.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{

    @FindBy(xpath ="(//input[@placeholder='Search job title or location'])[2]")
    public WebElement search_box;

    @FindBy(xpath = "(//li[@role='option'])[1]/a")
    public WebElement select_first_option;
}

