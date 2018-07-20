Feature: Edit the residue generator registration data
  As a residue generator logged into the system
  I want to edit my registration data
  so that i can keep my registration data up to date

  
  Scenario: Alterar nome do residue generator
	Given o sistema tem um residue generator com nome "Nuka Cola"
	When eu troco o seu nome para "Restaurante abc"
	Then o sistema nao deve alterar o nome no banco de dados

 Scenario: Alterar cnpj do residue generator
 	Given o sistema tem um residue generator de cnpj "0000000"
 	When eu troco seu cnpj para "1043578094"
 	Then o sistema deve alterar o cnpj no banco de dados

  #if ($ All the fields are filled correctly)
@ignore
  Scenario: All the fields are filled correctly
    Given the system has a residue generator with the address "Bubble road number 4"
    When I change it to "Fool street number 0"
    Then the system should store the residue generator with the new address in the data base
  #end

  #if($Residue generator registration data edit success web page)
@ignore
  Scenario: Residue generator registration data edit success web page
    Given I am at the residue generator edit page
    When  I fill the address field with "Fool's street number 0"
    And   fill all the required fields correctly
    And   submit my changes
    Then  I should see a message indicating that the changes are properly stored
  #end

@ignore
  Scenario: Some of the required registration data fields are blank
    Given the system has a residue generator with the address "Bubble road number 4"
    When  I do not fill the address field
    And   confirm my changes
    Then  the system should not store the changes

@ignore
  Scenario: The registration data changes results in an existing residue generator
    Given the system has a residue generator with the address "Bubble road number 4"
    When I change it address to "Bubble road number 4"
    Then the system should not store the changes


  Scenario: Residue generator registration data edit fail
    Given I am at the residue generator edit page
    When I fill the address field with ""
    And fill all the required fields correctly
    And submit my changes
    Then I should see a message indicating that an error occurred

   #see if there is another scenarios to implement