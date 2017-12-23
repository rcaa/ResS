package steps

import static cucumber.api.groovy.EN.*
import residueGenerator.ResidueGenerator;

Given(~'^existe um gerador de residuos armazenado no sistema com nome "([^\"]*)" e cnpj "([^\"]*)"$'){ String nome, String cnpj ->
	GeneratorTestDataAndOperations.criarGerador(nome, "Restaurante", "Rua das Caixas", 20, 500, cnpj)
	
	def gerador = ResidueGenerator.findByNameGeneratorAndCnpj(nome, cnpj)
	assert gerador != null
}

When(~'^deleto o gerador com nome "([^\"]*)" e cnpj "([^\"]*)"$'){ String nome, String cnpj ->
    def gerador = ResidueGenerator.findByNameGeneratorAndCnpj(nome, cnpj)
	GeneratorTestDataAndOperations.deleteGenerator(gerador)
}

Then(~'nao existe um gerador de residuos armazenado no sistema com nome "([^\"]*)" e cnpj "([^\"]*)"$'){ String nome, String cnpj ->
	def gerador = ResidueGenerator.findByNameGeneratorAndCnpj(nome, cnpj)
	assert gerador == null
}