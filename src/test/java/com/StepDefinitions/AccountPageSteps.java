package com.StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Pages.AccountPage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AccountPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
  
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(final DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps();
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   accountPage = loginpage.doLogin(list.get(0).get("username"), list.get(0).get("password"));
	   
	   
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(final DataTable dataTable) {
	   List<String> ExpectedList = dataTable.asList();
	   System.out.println("Expected List is : "+ExpectedList );
	  List<String> actualList =  accountPage.getAccountsSectionsList();
	  System.out.println("Actual List is : "+ actualList );
	  Assert.assertTrue(actualList.containsAll(ExpectedList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer int1) {
		int expectedCount = int1;
		int actualCount = accountPage.getAccountsSectionCount();
		Assert.assertEquals(expectedCount, actualCount);
		
	}
	
}
