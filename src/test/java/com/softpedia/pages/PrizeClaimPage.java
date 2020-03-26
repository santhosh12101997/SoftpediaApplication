package com.softpedia.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class PrizeClaimPage
{
	WebDriver driver;
	
	//Locators of prize claim page
	By click_prize_claim=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div/p/b[2]/a");
	By click_submit=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[3]/form/table/tbody/tr[3]/td/button");
	By i_icon=By.xpath("//*[@id=\"navicos\"]/li[2]");
	

	// Constructor
	public PrizeClaimPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void browserLaunch(String browser,String url)
	{
		try 
		{
		//To launch firefox Browser
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\finalproject\\MySoftPedia\\src\\test\\resources\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// To launch Chrome Browser
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\finalproject\\MySoftPedia\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		// to launch InternetExolorer
		else if (browser.equalsIgnoreCase("Internet Explore")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\finalproject\\MySoftPedia\\src\\test\\resources\\Driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();  
		}
		//to maximize the window
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	
	} catch (WebDriverException e) 
	{
		System.out.println("Browser could not be launched");
	}
}
		
	//To click i_icon
	public void i_icon() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(i_icon).click();
	}
	//To click discounts & giveaways using mouse action
	public void Discount_Giveaways() throws InterruptedException
	{	
		WebElement a=driver.findElement(By.linkText("Discounts & Giveaways"));
		Actions action=new Actions(driver);
		action.moveToElement(a).click().build().perform();
		Thread.sleep(3000);
	}
	
	//To click prize claim link
	public void link()
	{
	driver.findElement(click_prize_claim).click();
	}
	//To click submit without entering valid details and to  Handle alert message
	public void alertHandling() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(click_submit).click();
		Alert alert = driver.switchTo().alert();		 
        String alertMessage= driver.switchTo().alert().getText();		
        System.out.println(alertMessage);	
        Thread.sleep(5000);	
        alert.accept();	
	}
	
	//To take snapshot 
	public void screenshot(String path) throws IOException
	{	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File(path));
	}
	//To close the Browser 
	public void Quit() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
}

