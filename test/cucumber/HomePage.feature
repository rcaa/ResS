Feature: Home Page
  As an user of the ResS system
  I want to use the ResS home page
  So that i can have access to all the other features

  Scenario: Access ResS github repository
    Given I am at the main page
    When I select the github ribbon
    Then I should be at the ResS github repository page

  Scenario: Access residue generator index page
    Given I am at the main page
    When I access the Residue Generator area
    Then I should be at the residue generator index page

  Scenario: Access New User page
    Given I am at the main page
    And I access the User area
    When I access the New User page
    Then I should be at the New User page
    
  Scenario: Access New Residue Generator page
    Given I am at the main page
    And I access the Residue Generator area
    When I access the New Residue Generator page
    Then I should be at the New Residue Generator page