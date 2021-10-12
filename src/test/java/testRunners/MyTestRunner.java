package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"com.StepDefinitions"},
		monochrome = true,
		plugin = {"pretty", "rerun:target/failedrerun.txt", "html:target/htmlreport.html"				
		}
		)
public class MyTestRunner {

}
