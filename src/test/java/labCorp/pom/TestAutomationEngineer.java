package labCorp.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestAutomationEngineer extends BasePage {

    @FindBy(css = "h1[class=\'job-title\']")
    public WebElement job_title;

 //   @FindBy(xpath = "(//span[3]/span/text())[4]")

    @FindBy(xpath = "//span[@class='au-target jobId']")
    public WebElement job_id;

    @FindBy(xpath = "//button[@aria-label='This job is available in 2 locations See all']")
    public WebElement btn_see_all_locations;

    @FindBy(xpath = "//span[@data-ph-id='ph-job-fields-1632216542376-ph-job-details-v1glzi12-5vwo7o']")
    public List <WebElement> locations;

    @FindBy(xpath = "//button[@class='close ph-a11y-close-multi-location au-target']")
    public WebElement btn_close;

    @FindBy(xpath = "(//ul/li/p)[1]")
    public WebElement text_bachelor_degree;

    @FindBy(xpath = "(//ul/li/p)[23]")
    public WebElement text_programming_languages;

    @FindBy(xpath = "(//ul/li/p)[24]")
    public WebElement text_automation_tools;

    @FindBy(xpath = "(//ppc-content[contains(.,'Apply Now')])[2]")
    public WebElement btn_apply_now_2;

    @FindBy(xpath = "//li[@class='job-map']//a[@aria-label='Job Map']")
    public WebElement job_seach;

}
