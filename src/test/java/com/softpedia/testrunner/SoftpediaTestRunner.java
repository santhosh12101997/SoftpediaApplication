package com.softpedia.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	
@RunWith(Cucumber.class)

@CucumberOptions
(
	features = "D:\\selenium projects\\Softpedia_Application-master\\src\\main\\resources\\feature\\Testscenario.feature",
	plugin = {"pretty", "html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport","com.cucumber.listener.ExtentCucumberFormatter:reports/Extentreports/Extentreport.html"},
	tags = {"@tc_01_register, @tc_02_login, @tc_03_phonesearch,	@tc_04_prizeclaim, @tc_05_selectgame"},
	glue = {"com.softpedia.stepdefinition"},
	monochrome = true
) 
public class SoftpediaTestRunner 
{
	@AfterClass
	  public static void extendReport() 
	{ 
		Reporter.loadXMLConfig("D:\\selenium projects\\Softpedia_Application-master\\src\\test\\resources\\extent-config.xml");
	}
}

