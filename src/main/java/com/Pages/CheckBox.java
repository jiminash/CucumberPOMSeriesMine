package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox extends BasePage{
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Home']")
	WebElement Home;
	@FindBy(xpath = "//button[@title='Toggle' and @class='rct-collapse rct-collapse-btn']")
	WebElement firstdrop;
	@FindBy(xpath = "//span[text()='Desktop']")
	WebElement Desktop;
	@FindBy(xpath = "//span[text()='Notes']")
	WebElement Notes;
	@FindBy(xpath = "//div[@class='check-box-tree-wrapper']/div/ol/li/span/label/span[1]")
	WebElement Homemain;
	@FindBy(xpath = "//span[text()='desktop']")
	WebElement list;
		
	public CheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean SelectCheckBox() {
		if(!utils.checkIFCheckBoxSelected(Homemain)) {
			utils.clickElement(firstdrop);
			utils.wait(driver, Desktop);
			utils.clickElement(Desktop);
			utils.wait(driver, list);
			return list.isDisplayed();
		}
		
		return false;
	}
	

}
