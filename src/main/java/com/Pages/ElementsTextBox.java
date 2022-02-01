package com.Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsTextBox extends BasePage{

	private WebDriver driver;

	@FindBy(css = "textarea#currentAddress")
	WebElement currentAddress;
	@FindBy(css = "input#userName")
	WebElement name;
	@FindBy(css = "input#userEmail")
	WebElement email;
	@FindBy(css = "textarea#permanentAddress")
	WebElement PermanentAddr;
	@FindBy(css = "button#submit")
	WebElement submit;
	@FindBy(xpath = "//span[text()='Check Box']")
	WebElement CheckBox;
	String initial="//div[@class='border col-md-12 col-sm-12']/p[text()=\'";
	String ending ="\'] ";
	

	public ElementsTextBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterTextBox(List<String> list) {
		utils.SendText(name, list.get(0));
		utils.SendText(email, list.get(1));
		utils.SendText(currentAddress, list.get(2));
		utils.SendText(PermanentAddr, list.get(3));
		utils.clickElementwithJSExec(submit, driver);
	}

	public boolean displayDetails(List<String> list) {		
		for(String e : list) {
			String path = initial+e+ending;	
			utils.wait(driver, path);
			WebElement ele = utils.findElement(driver, path);
			if(ele!=null && ele.isDisplayed()) {
				return true;
			}
			else {
				break;
			}	   
		}
		return false;
		
	}
	
	public CheckBox goToCheckBox() {
		
		utils.clickElement(CheckBox);
		return new CheckBox(driver);
		
	}


}
