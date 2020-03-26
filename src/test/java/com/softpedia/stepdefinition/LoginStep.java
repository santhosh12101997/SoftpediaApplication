package com.softpedia.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.softpedia.pages.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep 
{
	WebDriver driver; 
	
	//To create object for Login page
	LoginPage login=new LoginPage(driver);
	
	//To call the methods in login page
	@Given("^User is on website Home Page$")
	public void user_is_on_website_Home_Page() throws Throwable 
	{
	    login.browserLaunch("chrome","https://www.softpedia.com/");
	}

	@When("^User nagivate to Login Page$")
	public void user_nagivate_to_Login_Page() throws Throwable 
	{
	    login.userIcon();
	}

	@And("^User login using \"([^\"]*)\" and \"([^\"]*)\" with vaild deatils$")
	public void User_login_using_and_with_vaild_deatils(String arg1, String arg2) throws Throwable 
	{
	    login.enterData(arg1, arg2);
	}

	@And("^Click on login button \"([^\"]*)\"$")
	public void click_on_login_button(String arg1) throws Throwable 
	{
		login.logIn(arg1);
	}
	@Then("^User logout from webpage$")
	public void user_logout_from_webpage() throws Throwable 
	{
		login.logOut();
		login.screenshot("D:\\selenium projects\\Softpedia_Application-master\\src\\test\\resources\\Screenshot\\login.png");
		login.quit();
	}


}
