package com.softpedia.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

public class PhoneSearchPage 
{
	WebDriver driver;
	
	By phone_finder=By.linkText("//*[@id=\"wrapper\"]/div[2]/div/div[20]/div[2]/a");
	By click_go=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[4]/div[2]");
	

	// Constructor
	public PhoneSearchPage(WebDriver driver) 
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
	
		} 
		catch (WebDriverException e) 
		{
			System.out.println("Browser could not be launched");
		}
}
		
	
	//To choose brand of the phone
	public void phoneBrand() throws InterruptedException
	{	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mbfilt_brand\"]/div[2]")).click();
		WebElement brand=driver.findElement(By.xpath("//*[@id=\"mbfilt_brand\"]/ul/li[3]"));
		Actions action=new Actions(driver);
		action.moveToElement(brand).click().build().perform();
	}
	
	//To choose platform of the phone
	public void phonePlatform() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mbfilt_platform\"]/div[2]")).click();
		WebElement platform=driver.findElement(By.xpath("//*[@id=\"mbfilt_platform\"]/ul/li[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(platform).click().build().perform();	
	}
	
	//To choose battery of the phone
	public void phoneBattery() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mbfilt_battery\"]/div[2]")).click();
		WebElement battery=driver.findElement(By.xpath("//*[@id=\"mbfilt_battery\"]/ul/li[1]"));
		Actions action=new Actions(driver);
		action.moveToElement(battery).click().build().perform();
	}
	
	//To choose availability of the phone
	public void phoneAvailability() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mbfilt_availability\"]/div[2]")).click();
		WebElement availability=driver.findElement(By.xpath("//*[@id=\"mbfilt_availability\"]/ul/li[3]"));
		Actions action=new Actions(driver);
		action.moveToElement(availability).click().build().perform();
		Thread.sleep(1000);
	}
	
	//To click go button
	public void go()
	{
		driver.findElement(click_go).click();
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