package labCorp.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import labCorp.pom.CareerPage;
import labCorp.pom.MainPage;
import labCorp.pom.TestAutomationEngineer;
import labCorp.utilities.Driver;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TaskCareersLink {

    TestAutomationEngineer testAutomationEngineer = new TestAutomationEngineer();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

    List<String> windowHandles = new ArrayList<>();

    @Given("User navigates to {string}")
    public void user_navigates_to(String string) {
        Driver.getDriver().get(string);
        Driver.getDriver().findElement(By.xpath("(//button[@aria-label='Close'])[1]")).click();
    }

    @When("User finds and clicks on {string} link")
    public void user_finds_and_clicks_on_link(String string) {
        MainPage mainPage = new MainPage();
        mainPage.careers_link.click();
    }

    @Then("Search for a position {string}, select and browse to the position")
    public void search_for_a_position_select_and_browse_to_the_position(String string) {
        CareerPage careerPage = new CareerPage();
        careerPage.search_box.sendKeys(string);
        wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.xpath("(//li[@role='option'])[1]/a"))));
        careerPage.select_first_option.click();
    }

    @Then("Confirm Job Title {string}")
    public void confirm_job_title(String string) {

        Assertions.assertEquals(testAutomationEngineer.job_title.getText(), string);
    }

    @Then("Confirm Job Location")
    public void confirm_job_location(List<String> expectedLocations) {

        testAutomationEngineer.btn_see_all_locations.click();
        List<String> actualLocations = new ArrayList<>();

        for (WebElement eachLocation : testAutomationEngineer.locations) {
            System.out.println("eachLocation = " + eachLocation.getText());
            actualLocations.add(eachLocation.getText());
        }

        Assertions.assertEquals(expectedLocations, actualLocations);
        testAutomationEngineer.btn_close.click();
    }

    @Then("Confirm Job Id {string}")
    public void confirm_job_id(String expectedJobId) {

        String[] arrOfStr = testAutomationEngineer.job_id.getText().split(":");

        String actualJobId = arrOfStr[1].trim();
        System.out.println(actualJobId);

        Assertions.assertEquals(expectedJobId, actualJobId);
    }

    @Then("Confirm text")
    public void confirm_text(List<String> expectedText) {

        List<String> actualTextList = new ArrayList<>();
        actualTextList.add(testAutomationEngineer.text_bachelor_degree.getText());
        actualTextList.add(testAutomationEngineer.text_programming_languages.getText());
        actualTextList.add(testAutomationEngineer.text_automation_tools.getText());

        Assert.assertEquals(expectedText, actualTextList);
    }

    @Then("Click Apply Now and switch to another window {string}")
    public void click_apply_now_and_switch_to_another_window(String expectedTitleAfterClick) {

        testAutomationEngineer.btn_apply_now_2.click();

        for (String each : Driver.getDriver().getWindowHandles()) {
            windowHandles.add(each);
        }

        Driver.getDriver().switchTo().window(windowHandles.get(1));

        Assert.assertEquals(expectedTitleAfterClick, Driver.getDriver().getTitle());
    }

    @Then("Click to Return to Job Search")
    public void click_to_return_to_job_search() {
        Driver.getDriver().switchTo().window(windowHandles.get(0));
        testAutomationEngineer.job_seach.click();

        String expectedTitleAfterClick = "Search results | Available job openings at Labcorp";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitleAfterClick, actualTitle);
    }


}
