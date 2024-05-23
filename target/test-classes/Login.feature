Feature: To Test Login functionality for XYZ App
	
	Scenario: To Test Login with Correct Credentials
		
		Given I am a user for XYZ app
		When I enter correct username and password
		Then I should be able to login
