Feature: Login to Application 

Scenario Outline: Test to validate login 
	Given Initialize the browser with chrome 
	And Navigate to "http://www.qaclickacademy.com/" site 
	And Click on Login link in home page to land on secure sign in page 
	When User enters <username> and <password> and logs in 
	Then Verify that login status is <status> 
	And Close the browser 
	
	Examples: 
		|username					|password		|status		|
		|manohargudipalli@gmail.com	|Ishwarya#447	|sucessful	|
		|test123@gmail.com			|12456			|failed		|
		
		
		
		
		
