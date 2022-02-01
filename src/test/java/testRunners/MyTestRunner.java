package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/Links.feature"},
		glue = {"com.StepDefinitions"},
		monochrome = true,
		plugin = {"pretty", "rerun:target/failedrerun.txt", "html:target/htmlreport.html"	, "testRunners.ListenerPlugins"
		},
		dryRun = false,
		tags = "not @skip_scenario"
		
		)
public class MyTestRunner {

}
