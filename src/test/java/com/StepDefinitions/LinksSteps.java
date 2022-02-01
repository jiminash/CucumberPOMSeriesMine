package com.StepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;

import com.Pages.Links;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LinksSteps {

	Links li ;


	@Given("user tries each link")
	public void user_tries_each_link() throws MalformedURLException, IOException {
      DriverFactory.getDriver().get("https://demoqa.com/links");
      li = new Links(DriverFactory.getDriver());
      li.validatelink("https://demoqa.com/links");
	}
	
	@Given("user tries the links {string}")
	public void user_tries_the_links(String string) throws MalformedURLException, IOException {
		DriverFactory.getDriver().get("https://demoqa.com/links");
	      li = new Links(DriverFactory.getDriver());
		li.validateOtherlink("https://demoqa.com/", string);
	}

	@Then("new tab is opened")
	public void new_tab_is_opened() {
		
	}

	@Then("window to be closed")
	public void window_to_be_closed() {
		li.closeWindow();
	}

}
