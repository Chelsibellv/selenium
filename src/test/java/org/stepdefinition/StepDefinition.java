package org.stepdefinition;

import org.pageclass.POJOLogin;
import org.reusable.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {

	

	@When("User has to enter the valid username and valid password")
		public void user_has_to_enter_the_valid_username_and_valid_password() {
			POJOLogin p=new POJOLogin();
			p.getUsername().sendKeys("chelsi");
			p.getPassword().sendKeys("123");
		    
		}

	@When("User has to click the login button")
	public void user_has_to_click_the_login_button() {
		POJOLogin p=new POJOLogin();
		p.getLogin().click();

	}
	
	@When("User has to enter the Invalid {string} and Invalid {string}")
	public void user_has_to_enter_the_Invalid_and_Invalid(String user, String pass) {
	  POJOLogin w=new POJOLogin();
	  w.getUsername().sendKeys(user);
	  w.getPassword().sendKeys(pass);
	}

	
}
