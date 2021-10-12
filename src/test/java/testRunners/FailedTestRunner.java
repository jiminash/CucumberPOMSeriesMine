package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = {"com.StepDefinitions"},
		plugin = {"pretty", "rerun:target/failedrerun.txt", "html:target/htmlreport.html"},
		features = {"@target/failedrerun.txt"}
		)

public class FailedTestRunner {

}
