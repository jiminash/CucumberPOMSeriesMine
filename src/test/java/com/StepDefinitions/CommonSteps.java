package com.StepDefinitions;

import org.junit.Assert;

import com.Pages.BasePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BasePage {
	

	private static String title;
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = utils.getTitle(DriverFactory.getDriver());
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}
	 
}
