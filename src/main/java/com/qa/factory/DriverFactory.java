package com.qa.factory;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
// adde din driver
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			//			ChromeOptions options = new ChromeOptions();
			//			options.addArguments("headless");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			//	chromePrefs.put("profile.default_content_settings.popups", 0);
			String downloadFilepath = "C:\\Users\\asjagade\\Documents\\Downloads";
		//	chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("deviceName", "Nexus 5");
//			chromePrefs.put("width", 360);
//			chromePrefs.put("height", 640);
//			chromePrefs.put("pixelRatio", 3.0);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("mobileEmulation", chromePrefs);
			//	Map<String, String> mobileEmulation = new HashMap<>();
			//	ChromeOptions chromeOptions = new ChromeOptions();
			//	chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		//	WebDriver driver = new ChromeDriver(options);
			WebDriverManager.chromedriver().setup();
			System.out.println("chromedriver is initiated");
			tlDriver.set(new ChromeDriver(options));
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
