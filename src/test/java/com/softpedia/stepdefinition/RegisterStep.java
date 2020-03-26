package com.softpedia.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.softpedia.pages.RegisterPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RegisterStep 
{
	WebDriver driver; 
	//To create object for register page
	RegisterPage register=new RegisterPage(driver);

	//To call the methods in register page
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable 
	{
		System.out.println("User is in Homepage");
	}

	@And("^User enters UserName,Emailid,Password and Repassword from excel data$")
	public void user_enters_UserName_Emailid_Password_and_Repassword_from_excel_data() throws Throwable 
	{
		for(int i=1;i<=15;i++)
		{
		register.browserLaunch("chrome","https://www.softpedia.com/");
		register.userIcon();
		register.enterData(i);
		register.register();
		register.screenshot("D:\\selenium projects\\Softpedia_Application-master\\src\\test\\resources\\Screenshot\\\\registration.png");
		register.quit();
		}
	}

	@Then("^Message display Registration UnSuccessfull$")
	public void message_display_Registration_UnSuccessfull() throws Throwable
	{
		System.out.println("Unable to Register");
	}

}
