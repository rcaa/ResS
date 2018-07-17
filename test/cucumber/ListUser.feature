Feature: List registered users
  As a administrator logged in
  I want to list all registered users
  so that I see all the users that are registered in the system
  

	Scenario: view registered users 
		Given I am at the home page
		When  I go to the user page
		Then  I see the list of all users registered in the system
