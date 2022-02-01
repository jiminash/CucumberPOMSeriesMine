package com.StepDefinitions;

import java.util.List;
import org.junit.Assert;

import com.Pages.ElementsTextBox;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ElementTextBoxSteps {
	
	private ElementsTextBox elementTextBox = new ElementsTextBox(DriverFactory.getDriver());
	
	@Given("user navigates to textbox")
	public void user_navigates_to_textbox() {
		DriverFactory.getDriver().navigate().to("https://demoqa.com/text-box");
		
	}

	@When("user provides the values")
	public void user_provides_the_values(DataTable dt) {
		List<String> list = dt.asList();
		System.out.println(list);
		elementTextBox.enterTextBox(list);
		
	}

	@Then("details are displayed in page")
	public void details_are_displayed_in_page_with_values(DataTable dt) {
		List<String> list = dt.asList();
	  boolean b = elementTextBox.displayDetails(list);
	  System.out.println(list);
		Assert.assertTrue("List is not found", b);
		
	}


	
}
