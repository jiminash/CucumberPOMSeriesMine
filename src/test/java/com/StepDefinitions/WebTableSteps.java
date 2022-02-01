package com.StepDefinitions;

import java.util.List;
import org.junit.Assert;
import com.Pages.WebTable;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebTableSteps {
	
	private WebTable webtable = new WebTable(DriverFactory.getDriver());
	
	@Given("user navigates to WebTable")
	public void user_navigates_to_web_table() {
		DriverFactory.getDriver().get("https://demoqa.com/webtables");
	}

	@Given("user searchs the first row")
	public void user_searchs_the_first_row() {
		webtable.selectRow();
		webtable.addValues();
	}

	@Then("it matches the list")
	public void it_matches_the_list(DataTable dataTable) {
		
		List<String> lists = dataTable.values();
	  Assert.assertTrue(webtable.containsValueFromTable(lists));
	}
	
	@Given("user enters the word")
	public void user_enters_the_word() {
		webtable.selectRow();
		webtable.searchTable();
		webtable.addValues();
		
	}

	@Then("item is listed")
	public void item_is_listed() {
		Assert.assertTrue(webtable.containsValueFromTable("Cierra"));
	}

}
