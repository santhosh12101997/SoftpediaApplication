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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ExcelUtility.Excel_data;



public class RegisterPage 
{
	WebDriver driver;
	
	//To create object of Exce_data class
	Excel_data ed = new Excel_data();
	
	// Locators for register page
	By click_user_icon=By.xpath("//*[@id=\"navicos\"]/li[3]");
	By register_now=By.xpath("//*[@id=\"spovl1\"]/div/div/div[1]/a[3]");
	By register_user=By.id("reguser");
	By register_email=By.id("regmail");
	By register_pass=By.id("regpass1");
	By register_re_pass=By.id("regpass2");
	By register_button=By.id("regbtn");
	

	// Constructor
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void browserLaunch(String browser,String url)
	{
		try {
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
		
	
	//To click the user_icon and register_now  
	public void userIcon()
	{
		driver.findElement(click_user_icon).click();
		System.out.println("click the user icon");
		driver.findElement(register_now).click();
		System.out.println("click on register now button");
	}
	
	//To enter the necessary credentials 
	public void enterData(int i) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		driver.findElement(register_user).sendKeys(ed.excel_username(i));
		Thread.sleep(1000);
		driver.findElement(register_email).sendKeys(ed.Email(i));
		Thread.sleep(2000);
		driver.findElement(register_pass).sendKeys(ed.excel_password(i));
		Thread.sleep(2000);
		driver.findElement(register_re_pass).sendKeys(ed.excel_repassword(i));
		Thread.sleep(2000);
	}
	
	//To click register button
	public void register()
	{
		driver.findElement(register_button).click();
	}
	
	//To take snapshot 
	public void screenshot(String path) throws IOException
	{	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File(path));
	}
	
	//To close the browser
	public void quit() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
}



	