package com.StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(value = "@skip_scenario" , order = 0)
	public void skip_scenario(Scenario scenario) {
		System.out.println("TO SKIP THE SCENARIO");
		System.out.println("The Skipped Scenario is: "+scenario.getName());
		Assume.assumeTrue(false);
	}

	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);

	}

	@AfterStep	
	public void addScreenShot(Scenario scenario) throws IOException {
		//	String screenshotName = scenario.getName().replaceAll(" ", "_");
//		final byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(sourcePath, "image/png", "image");
		
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		String ScreenShotPath = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".png";
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcePath, new File(ScreenShotPath));
		//ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenShotPath);
		
		String path = sourcePath.getAbsolutePath();
		scenario.attach(path, "image/png", screenshotName);
			
	}

	@After(order = 1)
	public void quitBrowser() {
		driver.quit();
		System.out.println("driver is closed");
	}

//	@After(order = 0)
//	public void tearDown(Scenario scenario) throws IOException {
//		if (scenario.isFailed()) {
//			// take screenshot:
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			String ScreenShotPath = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+"png";
//			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(sourcePath, new File(ScreenShotPath));
//			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ScreenShotPath);
//		}
//	}

}
