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

public class LoginPage 
{

	WebDriver driver;
	WebElement Login;
	// Locators of Login page
	By click_user_icon=By.xpath("//*[@id=\"navicos\"]/li[3]");
	By emailid=By.id("_lu");
	By pass=By.id("_lp");
	By login=By.xpath("//*[@id=\"spovl1\"]/div/div/form/input[3]");
	By setting=By.xpath("//*[@id=\"navicos\"]/li[3]");
	By logout=By.xpath("//*[@id=\"topovl1\"]/ul/li[4]/a");
	
	
	// Constructor
	public LoginPage(WebDriver driver) 
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
		
		} catch (WebDriverException e) 
		{
			System.out.println("Browser could not be launched");
		}
	}
				
			//To click the user icon
		public void userIcon()
		{
			Login=driver.findElement(click_user_icon);
			Login.click();
			System.out.println("click the user icon");
		}
		
		//To enter the login data
		public void enterData(String email, String password) throws InterruptedException
		{
			Thread.sleep(3000);
			driver.findElement(emailid).sendKeys(email);
			Thread.sleep(1000);
			driver.findElement(pass).sendKeys(password);
			
		}
		
		//To login
		public void logIn(String message) throws InterruptedException
		{
			Thread.sleep(3000);
			driver.findElement(login).click();
			System.out.println(message);
		}
		//To logout 
		public void logOut() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.findElement(setting).click();
			Thread.sleep(3000);
			driver.findElement(logout).click();
		}
			
		//To take screenshot of login page
		public void screenshot(String path) throws IOException, InterruptedException
		{
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File Source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File(path));
			Thread.sleep(3000);
			
		}
	
		//To close the browser
		public void quit() 
		{
				driver.close();	
		}
}