Feature: register a residue generator
  As an administrator of the ResS system
  I want to register residue generators
  So that I can use and manage information of these generators

@ignore
  Scenario: new valid generator
    Given The system has no generator with the address "Bubble Street number 7"
    When I register a new generator of residue with the address "Bubble Street number 7"
    Then The new residue generator is properly stored by the system

@ignore
  Scenario: new valid generator web
    Given I am at the register new generator page
    When I fill the generator details with the address "Bubble Street number 7"
    And I register the new generator
    Then I should see a message indicating that the action was successful

@ignore
  Scenario: duplicated residue generator
    Given The system has a generator with the address "Bubble road number 4" already stored
    When I register a different generator of residue with the address "Bubble road number 4"
    Then The new residue generator is not stored twice by the system

  Scenario: duplicated residue generator web
    Given I am at the register new generator page
    When I fill the generator details with the address "Bubble Street number 7"
    And I register the new generator
    And I register a different generator with the address "Bubble Street number 7"
    Then I should see an error message

  Scenario: new incomplete residue generator
    Given The system has no generator with the address "Bubble Street number 8"
    When I register a new generator of residue with some info left incomplete
    And The address "Bubble Street number 8"
    Then The new residue generator is not stored by the system

  Scenario: new incomplete residue generator web
    Given I am at the register new generator page
    When I fill the generator details with some fields left incomplete
    And I register the new generator
    Then I should see an error message
    
  Scenario: new residue generator with duplicated cnpj
  	Given o sistema possui um gerador de residuos com o cnpj "35401447000157"
  	When eu crio um novo gerador de residuos com o nome "Boa Vista" e o cnpj "35401447000157"
  	Then o sistema nao armazena o novo gerador de residuos