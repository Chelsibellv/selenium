package org.pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reusable.BaseClass;

public class POJOLogin extends BaseClass{
	
	//Constructor
	public POJOLogin() {
		PageFactory.initElements(driver, this);
	}
	//Encapsulation
	@FindBy(id="username")
	private WebElement username;
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}	

	public WebElement getLogin() {
		return login;
	}
	@FindBy(id="password")
	private WebElement password;
	
	public WebElement getForgotpassword() {
		return forgotpassword;
	}

	public WebElement getNewregister() {
		return newregister;
	}
	@FindBy(id="login")
	private WebElement login;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	private WebElement forgotpassword;
	
	@FindBy(xpath="//a[text()='New User Register Here']")
	private WebElement newregister;
	

}
