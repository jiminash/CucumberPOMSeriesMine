package com.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
		
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public void SendText(WebElement element,String value) {
		try {
			element.sendKeys(value);
		}
		catch(IllegalArgumentException e) {
			System.out.println("value is null");
		}
	}
	
	public void clickElement(WebElement element) {
		try {
		element.click(); }
		catch(Exception e) {
			System.out.println("element is not clickable");
			e.printStackTrace();
		}
	}
	public void clickElementwithJSExec(WebElement element, WebDriver driver) {
		
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); }
		catch(Exception e) {
			System.out.println("element is not clickable");
			e.printStackTrace();
		}
	}
	
	
	public WebElement findElement(WebDriver driver, String path) {
		WebElement ele = null ;
		try {
	       ele  = driver.findElement(By.xpath(path)); 
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found "+e);
		}
		return ele;
	}
	
		
	public void wait(WebDriver driver , String path) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
		}
		catch(TimeoutException e) {
			System.out.println("element not found "+e);
		}
	}
	
	public void wait(WebDriver driver , WebElement path) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 15);
	//	wait.until(ExpectedConditions.elementToBeClickable(path));
		wait.until(ExpectedConditions.visibilityOf(path));
		}
		catch(TimeoutException e) {
			System.out.println("element not found "+e);
		}
	}
	
	public boolean checkIFCheckBoxSelected(WebElement element) {
		boolean b = false ; 
		if(element != null) {
		 b = element.isSelected(); 
		 System.out.println(b);
		 }
		 
		return b;
		
	}
	
	public boolean elementIsSelected(WebElement element) {
		
		if(element != null) {
			return element.isSelected();
		}
		
		return false;
		
	}
	
public boolean elementIsDisplayed(WebElement element) {
		
		if(element != null) {
			return element.isDisplayed();
		}
		
		return false;
		
	}
		
		

}
