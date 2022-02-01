package com.StepDefinitions;

import java.util.List;

import org.junit.Assert;

import com.Pages.WebTableGuru99;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class WebTableGuru99Steps {
	
	private WebTableGuru99 Webtableguru;
	
	@Given("user navigates to WebTableGuru99")
	public void user_navigates_to_web_table_guru99() {
		DriverFactory.getDriver().get("http://demo.guru99.com/test/web-table-element.php");
		Webtableguru = new WebTableGuru99(DriverFactory.getDriver());
	}
	
	@Given("user searches the row {int}")
	public void user_searches_the_row(Integer int1) {
		List<String> lists = Webtableguru.getRowData(int1);
		System.out.println(lists);		
	}

	@Then("the data is visible")
	public void the_data_is_visible(DataTable dataTable) {	
		List<String> lists = dataTable.asList();
		System.out.println(lists);
		boolean b = Webtableguru.matchRowData(lists);
		Assert.assertTrue(b);
	}

	@Given("user searches the list")
	public void user_searches_the_list() {
			System.out.println(Webtableguru.getAllData());
	}

	@Then("all the datas is visible")
	public void all_the_datas_is_visible() {
		Webtableguru.allDataVisible();
	}



}
