package com.stepdefination;

import org.openqa.selenium.WebDriver;

import com.BaseClass.Base_class;
import com.Pom.Home_Page;
import com.testrunner.Test_Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class step_defination extends Base_class{
	public WebDriver driver = Test_Runner.driver;
	Home_Page HP = new Home_Page (driver);
	@Given("User launch the URL")
	public void user_launch_the_URL(String string) {
		launchUrl(string);
	    
	}

	@Given("User click on men")
	public void user_click_on_men() throws Exception {
		Thread.sleep(5000);
		HP.getLogin().click();

	}
}
