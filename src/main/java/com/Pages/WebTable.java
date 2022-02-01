package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebTable extends BasePage{
	
	private WebDriver driver;
	private List<String> lists = new ArrayList<String>();
		
	@FindBy(xpath = "//div[@class='rt-td']")
	List<WebElement> values;
	@FindBy(id = "searchBox")
	WebElement search;
	@FindBy(xpath = "//select[@aria-label='rows per page']")
	WebElement selectrow;
	
	public WebTable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addValues() {
		values.forEach((b) ->
		   lists.add(b.getText())
				);
	}
	
	public boolean containsValueFromTable(List<String> e) {
		System.out.println(lists);
	for(String b : e) {
		if(b != null) {
			return lists.contains(b);
			} 
		
		}
		return false;
	}
	
	public boolean containsValueFromTable(String e) {
		System.out.println(lists);
	  if (lists.contains(e) && !(lists.contains("Alden"))){
				 return true;
				} 
			return false;
		}
	
	public void searchTable() {
		utils.SendText(search, "Cierra");
	}
	
	public void selectRow() {
		//selectrow.click();
		Select s = new Select(selectrow);
		s.selectByValue("5");
		}

}
