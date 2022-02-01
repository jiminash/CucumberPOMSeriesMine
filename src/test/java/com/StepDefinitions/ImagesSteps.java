package com.StepDefinitions;

import org.junit.Assert;

import com.Pages.ImagePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ImagesSteps {
	
	ImagePage imgpage = new ImagePage(DriverFactory.getDriver());
	
	@Given("user goes to image page")
	public void user_goes_to_image_page() {
		DriverFactory.getDriver().get("https://demoqa.com/broken");
	}

	@Then("image is not displayed")
	public void image_is_not_displayed() {
		Assert.assertFalse(imgpage.validateImage());
	}
	
	@Given("user verifies the {string}")
	public void user_verifies_the(String string) {
		imgpage.verifyLinks(string);
	}


	@When("new page is opened in same tab {string}")
	public void new_page_is_opened_in_same_tab(String string) {
		imgpage.clickLink(string);
		}

}
