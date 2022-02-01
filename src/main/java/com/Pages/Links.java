package com.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Links extends BasePage{

	private WebDriver driver;
	private int respCode = 200;

	@FindBy( tagName = "a")
	List<WebElement> links;
	
	@FindBy(css = "#simpleLink")
	WebElement simpleLink;
	
	@FindBy(css = "#dynamicLink")
	WebElement dynamicLink;

	public Links(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}

	public void validatelink(String str) throws MalformedURLException, IOException{

		Iterator<WebElement> it = links.iterator();

		while(it.hasNext()) {

			String url = it.next().getAttribute("href");

			System.out.println(url);

			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if(!url.startsWith(str)){
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
			
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			
			con.setRequestMethod("HEAD");
			con.connect();

			respCode = con.getResponseCode();

			if(respCode >= 400){
				System.out.println(url+" is a broken link");
			}
			else{
				System.out.println(url+" is a valid link");
			}	
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeWindow(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		
		for(String window : set) {
			if(window.equalsIgnoreCase(mainWindow)) {
				driver.close();
				System.out.println(window+" is closed");
			}
		}
							
	}
	
	public void validateOtherlink(String str , String linktext) throws MalformedURLException, IOException{

//		Iterator<WebElement> it = links.iterator();
//
//		while(it.hasNext()) {
//
//			String url = it.next().getAttribute("href");
//
//			System.out.println(url);
//
//			if(url == null || url.isEmpty()){
//				System.out.println("URL is either not configured for anchor tag or it is empty");
//				continue;
//			}
//
//			if(!url.startsWith(str)){
//				System.out.println("URL belongs to another domain, skipping it.");
//				continue;
//			}
			
			switch(linktext) {
			case "simple":
			  utils.clickElementwithJSExec(simpleLink, driver);
			  break;			  
			case "dynamic":
			  utils.clickElement(dynamicLink);
			  break;
			}		
			
			
	     }
	
}
