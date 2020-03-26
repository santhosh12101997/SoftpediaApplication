package com.softpedia.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GamesPage 
{
	WebDriver driver;
	
	// Locators of Login page
	By games=By.xpath("//*[@id=\"wrapper\"]/div[1]/div[2]/div/div[3]/ul[1]/li[3]/a");
	By click_sidebar=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div/i[2]");
	By click_autonauts=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div/div/div[1]/div[4]/a");
	

	// Constructor
	public GamesPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void browserLaunch(String browser,String url)
	{
		try {
		// To launch firefox Browser
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\finalproject\\MySoftPedia\\src\\test\\resources\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// To launch Chrome Browser
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\finalproject\\MySoftPedia\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		// To launch InternetExolorer
		else if (browser.equalsIgnoreCase("Internet Explore")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\finalproject\\MySoftPedia\\src\\test\\resources\\Driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();  
		}
		// To maximize the window
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	
		} 
		catch (WebDriverException e) 
		{
			System.out.println("Browser could not be launched");
		}
}
		
	
	// To click the games tab in the homepage
	public void gameTab() throws InterruptedException
	{	
		driver.findElement(games).click();
		Thread.sleep(1000);
	}
	
	// To click the side bar in game page
	public void sideBar()
	{
		driver.findElement(click_sidebar).click();
	}
	
	// To select the required game
	public void selectGame() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(click_autonauts).click();
		Thread.sleep(3000);
	}
	
	// To take snapshot 
	public void screenshot(String path) throws IOException
	{	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File(path));
		//To scroll down from top of the page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");	
	}
	// To close the Browser 
	public void quit() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}


}
