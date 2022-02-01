package com.StepDefinitions;

import org.junit.Assert;

import com.Pages.RadioButton;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RadioButtonSteps {
		
	private boolean b;
	RadioButton radio = new RadioButton(DriverFactory.getDriver());
	
	@Given("user navigates to radioButton")
	public void user_navigates_to_radio_button() {
		DriverFactory.getDriver().get("https://demoqa.com/elements");
		radio.goToRadio();
	}

	@Given("user click the {string}")
	public void user_click_the(String string) throws InterruptedException {
		b = radio.radioButton(string);
	}

	@Then("userText is displayed")
	public void user_text_is_displayed() {
		Assert.assertTrue(b);
	}

	
}
