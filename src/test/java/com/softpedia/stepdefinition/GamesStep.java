package com.softpedia.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.softpedia.pages.GamesPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GamesStep 
{
	WebDriver driver; 
	
	//To create object for games page
	GamesPage game=new GamesPage(driver);
	
	//To call the methods in games page
	@Given("^User is on softpedia webpage$")
	public void user_is_on_softpedia_webpage() throws Throwable 
	{
		game.browserLaunch("chrome","https://www.softpedia.com/");
	}

	@When("^User click games tab$")
	public void user_click_games_tab() throws Throwable 
	{
		game.gameTab();
	}

	@And("^User click side bar$")
	public void user_click_side_bar() throws Throwable 
	{
		game.sideBar();
	}

	@Then("^Selected Game name is displayed$")
	public void selected_Game_name_is_displayed() throws Throwable 
	{
		game.selectGame();
		game.screenshot("D:\\selenium projects\\Softpedia_Application-master\\src\\test\\resources\\Screenshot\\Game_selection.png");
		game.quit();
	}

}
