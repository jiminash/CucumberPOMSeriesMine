package com.Pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableGuru99 {

	private WebDriver driver;
	private List<String> rowData = new ArrayList<String>();
	private List<List<String>> allData = new ArrayList<List<String>>();
	

	@FindBy(xpath = "//tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath = "//thead/tr/th")
	List<WebElement> col;
	

	public WebTableGuru99(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int getRowSize() {
		return rows.size();
	}

	public int getColSize() {
		return col.size();
	}

	public List<String> getRowData(int row){
		List<WebElement> rowDataElements =  driver.findElements(By.xpath("//tbody/tr["+row+"]/td"));

		for(WebElement e : rowDataElements) {
			rowData.add(e.getText());
		}
		return rowData;
	}

	public boolean matchRowData(List<String> lists){
		return lists.containsAll(rowData);
	}
	
	public List<List<String>> getAllData(){
			
		for(int i = 0 ; i < rows.size(); i++) {
		List<WebElement> rowColData = driver.findElements(By.xpath("//tbody/tr["+i+"]/td"));
		    for(WebElement ele : rowColData) {
		    	String data = ele.getText();
		    	rowData.add(data);
		       }
		 allData.add(rowData);
		}
		
		return allData;
	}
	
	public boolean allDataVisible() {
		
	
		return true;
		
	}
		
	public void  getcolData() throws ParseException {
		
		double r = 0 ;
		for (int i =1;i<rows.size();i++)
        {    
            String max = driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr["
        + (i+1)+ "]/td[4]")).getText();
            Double.parseDouble(max);
            
            NumberFormat f = NumberFormat.getNumberInstance();
            Number num = f.parse(max);
            max = num.toString();
            double m = Double.parseDouble(max);
            if(m>r)
             {    
                r=m;
             }
        }
        System.out.println("Maximum current price is : "+ r);
}
		

}
	






