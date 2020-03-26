package com.softpedia.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.softpedia.pages.PrizeClaimPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrizeClaimStep 
{
	WebDriver driver;
	//To create object for PrizeClaim page
	PrizeClaimPage prize=new PrizeClaimPage(driver);
	
	//To call the methods in PrizeClaim page
	@Given("^User is on softpedia Home Page$")
	public void user_is_on_softpedia_Home_Page() throws Throwable 
	{
		prize.browserLaunch("chrome","https://www.softpedia.com/");
	}

	@When("^User clicks i_icon and Discount & giveaways$")
	public void user_clicks_i_icon_and_Discount_giveaways() throws Throwable 
	{
		prize.i_icon();
		prize.Discount_Giveaways();
	}

	@And("^User navigates to prize claim page$")
	public void user_navigates_to_prize_claim_page() throws Throwable 
	{
		prize.link();
	}

	@And("^User clicks submit button without entering the details$")
	public void user_clicks_submit_button_without_entering_the_details() throws Throwable 
	{
		prize.alertHandling();
		prize.screenshot("D:\\selenium projects\\Softpedia_Application-master\\src\\test\\resources\\Screenshot\\\\prizeclaim.png");
	}

	@Then("^Successfull alert handle message is displayed$")
	public void successfull_alert_handle_message_is_displayed() throws Throwable 
	{
		
		prize.Quit();
	}
	

}

