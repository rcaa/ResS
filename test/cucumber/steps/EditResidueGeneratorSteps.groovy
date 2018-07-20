package steps

import pages.ResidueGeneratorEditPage
import pages.ResidueGeneratorShowPage
import residueGenerator.ResidueGenerator
import static cucumber.api.groovy.EN.*

// ---------------------------------------------EDIT SUCCESS---------------------------------------------

Given(~/^o sistema tem um residue generator de cnpj "(.*?)"$/) { String cnpj ->
	generator = ResidueGenerator.findByCnpj(cnpj)
	assert generator != null
}

When(~/^eu troco seu cnpj para "(.*?)"$/) { String novoCnpj ->
	cnpj = novoCnpj
	GeneratorTestDataAndOperations.editGeneratorCnpj(cnpj,generator)
}

Then(~/^o sistema deve alterar o cnpj no banco de dados$/) { ->
	assert ResidueGenerator.findByCnpj(cnpj) != null
}

Given(~/^o sistema tem um residue generator com nome "(.*?)"$/) { String nome ->
	 generator = ResidueGenerator.findByNameGenerator(nome)
	 assert generator != null
	}

When(~/^eu troco o seu nome para "(.*?)"$/) { String novoNome ->
	name = novoNome
    GeneratorTestDataAndOperations.editGeneratorName(name, generator)
}

Then(~/^o sistema nao deve alterar o nome no banco de dados$/) { ->
	assert ResidueGenerator.findByNameGenerator(name) == null
}

Given(~'^the system has a residue generator with the address "([^"]*)"$') { String address ->
    GeneratorTestDataAndOperations.createGenerator(address)
    generator = ResidueGenerator.findByAddressGenerator(address)
    assert generator != null
}

When (~'^I change it to "([^"]*)"$') {  String newAddress ->
    endereco = newAddress
    GeneratorTestDataAndOperations.editGenerator(endereco, generator)
}

Then(~'^the system should store the residue generator with the new address in the data base$') { ->
    assert ResidueGenerator.findByAddressGenerator(endereco) != null
}

Given(~'^I am at the residue generator edit page'){ ->
    to ResidueGeneratorEditPage
    at ResidueGeneratorEditPage
}

When(~'^I fill the address field with "([^"]*)"'){String address ->
    page.fillAddressField(address)
}

And(~'^fill all the required fields correctly'){ ->
    page.fillOtherFields()
}

And(~'^submit my changes'){ ->
    page.submitChanges()
}

Then(~'^I should see a message indicating that the changes are properly stored'){ ->
    to ResidueGeneratorShowPage
    at ResidueGeneratorShowPage

    def hasMessage = page.hasMessage()

    assert hasMessage != null
}

//---------------------------------------------LEAVING BLANK FIELDS------------------------------------------------------------


When(~'^I do not fill the address field$'){ ->
    nullAddress = null
}

And(~'^confirm my changes$'){ ->
    GeneratorTestDataAndOperations.editGenerator(nullAddress,generator)
}

Then(~'^the system should not store the changes'){ ->
    assert ResidueGenerator.findByAddressGenerator(endereco) != null
}

//------------------------------------------------DUPLICATED RESIDUE GENERATORS-------------------------------------------------


When(~'^I change it address to "([^"]*)"$'){ String newAddress  ->
    endereco = newAddress
    GeneratorTestDataAndOperations.editGenerator(endereco, generator)
}

//------------------------------------------------EDIT FAIL WEB PAGE------------------------------------------------------------

Then(~'^I should see a message indicating that an error occurred$'){ ->
    at ResidueGeneratorEditPage
    def errorBoolean = page.hasInvalidMessage()
    assert errorBoolean != false
}