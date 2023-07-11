package labCorp.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/features",
        glue = "labCorp/step_definitions",
        dryRun = false,
        tags = "@api or @ui",
        publish = true
)

public class TestRunner {
}
