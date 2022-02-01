package com.StepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.Pages.Buttons;
import com.qa.factory.DriverFactory;
import com.qa.utils.GetByfromWebEle;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ButtonSteps {
	
	private Buttons btn;
	 GetByfromWebEle geti;
	Logger logger = Logger.getLogger(ButtonSteps.class);
	
	
	@Given("user navigates to buttons")
	public void user_navigates_to_buttons() {
		logger.info("browser url is opned");
		DriverFactory.getDriver().get("https://demoqa.com/buttons");
		btn = new Buttons(DriverFactory.getDriver());
	}

	@Given("user clicks all click buttons available {string}")
	public void user_clicks_all_click_buttons_available(String string) {
		btn.clicks(string);	
		System.out.println(btn.clkBtn.toString()+"-------");
		geti = new GetByfromWebEle();
		System.out.println(geti.toByVal(btn.clkBtn));
		System.out.println(DriverFactory.getDriver().findElement(geti.toByVal(btn.clkBtn)).getText());
		logger.info("button is clicked");
		}

	@Then("its respective message is displayed {string}")
	public void its_respective_message_is_displayed(String string) {
		boolean b =  btn.getResult().equalsIgnoreCase(string);
		Assert.assertTrue(b,"is displayed");
	}

	@Then("its respective2")
	public void its_respective1_message() {
		System.out.println("respective1 ran");
		boolean b =  btn.getResult().equalsIgnoreCase("vcdv");
		Assert.assertTrue(b);
	}

	@Then("its respective3")
	public void its_respectives2() {
		boolean b =  btn.getResult().equalsIgnoreCase("dvdv");
		Assert.assertTrue(b);
	}
}
