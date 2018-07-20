Feature: register a user
  As an administrator of the ResS system
  I want to register a new user
  So that I can use and manage information of these users
  
   Scenario: failed to register new user with empty address
    Given The system has no user with the login "FULANO"
    When I register a new user with login "FULANO" and address "" 
    Then The new user with login "FULANO" is not stored by the system
    
    