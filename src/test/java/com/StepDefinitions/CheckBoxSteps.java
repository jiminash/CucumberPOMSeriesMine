package com.StepDefinitions;

import org.junit.Assert;

import com.Pages.BasePage;
import com.Pages.CheckBox;
import com.Pages.ElementsTextBox;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class CheckBoxSteps extends BasePage{
	
	private boolean b;
	CheckBox checkBox;
	ElementsTextBox textBox = new ElementsTextBox(DriverFactory.getDriver());
	
	@Given("user navigates to checkbox")
	public void user_navigates_to_checkbox() {
		DriverFactory.getDriver().get("https://demoqa.com/text-box");
		checkBox = textBox.goToCheckBox();
	}

	@When("user selects the desktop")
	public void user_selects_the_desktop() {
	 	b = checkBox.SelectCheckBox();
	}

	@Then("desktop is selected")
	public void desktop_is_selected() {
		Assert.assertTrue(b);
	}
	
	

}
