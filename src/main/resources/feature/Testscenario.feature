@Softpedia
Feature: SoftPedia Application

@tc_01_register
Scenario:	Account Registration

	Given User is on Home Page 
 	And User enters UserName,Emailid,Password and Repassword from excel data
	Then Message display Registration UnSuccessfull 

@tc_02_login
Scenario Outline:	Valid Login 

	Given User is on website Home Page
 	When User nagivate to Login Page
 	And User login using "<email>" and "<password>" with vaild deatils
 	And Click on login button "<message>"
 	Then User logout from webpage
 	
	Examples: 

	|email						|password	| message 		|
	|sk1675376@gmail.com		|12345678	|valid login	|
	|malarvizhimarie@gmail.com	|123456789	|valid login	|
 	
@tc_03_phonesearch
Scenario:	Searching for phone based on the requirements
	Given User is on phone finder page
	When User select brand,platform,battery and availability
	And User click go button
	Then Phone found message is displayed

@tc_04_prizeclaim
Scenario: Prize claim
	Given User is on softpedia Home Page
	When User clicks i_icon and Discount & giveaways
	And User navigates to prize claim page
	And User clicks submit button without entering the details
	Then Successfull alert handle message is displayed
	
@tc_05_selectgame
Scenario:	Game selection
	Given User is on softpedia webpage
	When User click games tab 
	And User click side bar
	Then Selected Game name is displayed