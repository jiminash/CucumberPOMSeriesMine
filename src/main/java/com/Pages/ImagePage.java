package com.Pages;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImagePage extends BasePage{

	private WebDriver driver;   

	@FindBy(xpath = "//p[text()='Broken image']/following::img[1]")
	WebElement brokenimg;

	@FindBy(linkText = "Click Here for Valid Link")
	WebElement validLink;

	@FindBy(linkText = "Click Here for Broken Link")
	WebElement InvalidLink;

	public ImagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateImage(){
		boolean imageDisplayed = false;

		try {
			imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", brokenimg);
			if (imageDisplayed) {
				System.out.println("DISPLAY - OK");
			}else {
				System.out.println("DISPLAY - BROKEN");
			}
		} 
		catch (Exception e) {
			System.out.println("Error Occured");
		}
		return imageDisplayed;
	}
	
	public void clickLink(String links) {
		
		try {
		switch(links) {		
		case "valid link":
			utils.wait(driver, validLink);
			utils.clickElementwithJSExec(validLink, driver);
			break;
		case "invalid link":
			utils.wait(driver, InvalidLink);
			utils.clickElementwithJSExec(InvalidLink, driver);
			break;
		}  }
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void verifyLinks(String links)
	{
		String linkUrl = null;
		switch(links) {		
		case "valid link":
			linkUrl = validLink.getAttribute("href");
			break;
		case "invalid link":
			linkUrl = InvalidLink.getAttribute("href");
			break;
		}
		try
		{
			URL url = new URL(linkUrl);

			//Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400)
			{
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}    

			//Fetching and Printing the response code obtained
			else{
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
			}
		}catch (Exception e) {}

	}
}



