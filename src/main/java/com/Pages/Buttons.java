package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buttons extends BasePage{
	
	private WebDriver driver;
	private String result;
	
	@FindBy(id = "doubleClickBtn")
	WebElement doubleClkBtn;
	@FindBy(id = "rightClickBtn")
	WebElement rightClkBtn;
	@FindBy(xpath ="//button[text()='Right Click Me']/following::button")
	public WebElement clkBtn;
	@FindBy(id = "doubleClickMessage")
	WebElement doubleClkMsg;
	@FindBy(id = "rightClickMessage")
	WebElement rightClkMsg;
	@FindBy(id = "dynamicClickMessage")
	public
	WebElement dynClkMsg;
	
	public Buttons(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getResult() {
		return result;
	}

	Actions ac ;
	
	public void clicks(String e) {
		ac = new Actions(driver);
		switch(e) {
		case "doubleClk":
		ac.doubleClick(doubleClkBtn).build().perform();
		utils.wait(driver, doubleClkMsg);
		 result = doubleClkMsg.getText();
		break;
		case "rightClk":
		ac.contextClick(rightClkBtn).build().perform();
		utils.wait(driver, rightClkMsg);
		 result = rightClkMsg.getText();
		break;
		case "Clk":
		ac.click(clkBtn).build().perform();
		utils.wait(driver, dynClkMsg);
		 result = dynClkMsg.getText();
		break;
		
		default: 
			System.out.println("no such clicks are found");
		}
	}

}
