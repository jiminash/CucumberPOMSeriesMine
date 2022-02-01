package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButton extends BasePage {	

	private WebDriver driver;

	@FindBy(xpath = "//label[text()='Yes']")
	private WebElement yes;
	@FindBy(xpath = "//label[text()='Impressive']")
	private WebElement impressive;
	@FindBy(css = "#noRadio")
	private WebElement no;
	@FindBy(xpath = "//span[text()='Radio Button']")
	private WebElement radioButton;
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement gettextyes;
	@FindBy(xpath = "//span[text()='Impressive']")
	private WebElement gettextImpressive;

	public RadioButton(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToRadio() {
		utils.wait(driver, radioButton);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(radioButton);
	}	

	public boolean radioButton(String ele) throws InterruptedException {

		if(ele.equalsIgnoreCase("yes")) {
			utils.wait(driver, yes);		
			utils.clickElementwithJSExec(yes, driver); 
			utils.wait(driver, gettextyes);
			return utils.elementIsDisplayed(gettextyes);
		}
		else {
			utils.wait(driver, yes);	
			utils.clickElementwithJSExec(impressive, driver);
			utils.wait(driver, gettextImpressive);
			return utils.elementIsDisplayed(gettextImpressive);
		}
	}



}
