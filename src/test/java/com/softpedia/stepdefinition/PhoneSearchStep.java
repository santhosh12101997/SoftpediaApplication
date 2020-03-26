package com.softpedia.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.softpedia.pages.PhoneSearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PhoneSearchStep 
{
	WebDriver driver; 
	
	//To create object for phone finder page
	PhoneSearchPage phone=new PhoneSearchPage(driver);
	
	//To call the methods in phone finder page
	@Given("^User is on phone finder page$")
	public void user_is_on_phone_finder_page() throws Throwable 
	{
	    phone.browserLaunch("chrome","https://mobile.softpedia.com/phoneFinder/");
	}

	@When("^User select brand,platform,battery and availability$")
	public void user_select_brand_platform_battery_and_availability() throws Throwable 
	{
	    phone.phoneBrand();
	    phone.phonePlatform();
	    phone.phoneBattery();
	    phone.phoneAvailability();
	}

	@And("^User click go button$")
	public void user_click_go_button() throws Throwable 
	{
		phone.go();
		phone.screenshot("D:\\selenium projects\\Softpedia_Application-master\\src\\test\\resources\\Screenshot\\phonefinder.png");
	}

	@Then("^Phone found message is displayed$")
	public void phone_found_message_is_displayed() throws Throwable 
	{
		System.out.println("Phone Found");
		phone.Quit();
	}
}
