package testRunners;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

//import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;
//@CucumberOptions(plugin = {“cucumberHooks.customReportListener”},
//monochrome=true,
//glue={“stepDefinitions”,”cucumberHooks”}, //Packagename
//features = {“src\\featureFiles”} //FolderName
//)

@RunWith(Cucumber.class)

@CucumberOptions(
		features = { "src/test/resources/features/button.feature" }, 
		glue = { "com.StepDefinitions" }, 
		plugin = { "pretty",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
      
		)

public class TestRunnerReports {
	
//	@DataProvider(parallel = true)
//	 @Override
//	 public Object[][] scenarios() {
//	 return super.scenarios();
//	 }

}
