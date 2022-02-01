package com.StepDefinitions;

import org.junit.Assert;

import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}
	
	@Then("user gets the error message")
	public void user_gets_the_error_message() {
		Assert.assertTrue(loginPage.errorFind());
	}

}
