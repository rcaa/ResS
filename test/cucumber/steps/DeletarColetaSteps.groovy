package steps

import pages.ColetaListPage
import pages.ColetaEditPage
import pages.ColetaDeletePage
import pages.ResidueGeneratorEditPage
import pages.ResidueGeneratorIndexPage
import HistoricoDeColeta.Coleta
import steps.*



import static cucumber.api.groovy.EN.*


Given(~/^Estou na pagina de visualizacao do ponto de coleta com nome "(.*?)"$/) { String arg1 ->
	ColetaTestDataAndOperations.createColeta("RU", "20/09/1996", "2001")
	to ColetaDeletePage
	at ColetaDeletePage
	
}

Given(~/^Eu seleciono a opcao para remocao do ponto de coleta com nome "(.*?)"|$/) { String arg1 ->
	assert withConfirm(false) {
		$("input", name: "_action_delete").click()} == "Are you sure?"
    }

When(~/^recuso a mensagem de confirmacao$/) { ->
    }

Then(~/^Eu visualizo ponto na pagina de listagem$/) { ->
    at ColetaDeletePage 
}

When(~/^aceito a mensagem de confirmacao$/) { ->
	assert withConfirm(true) {
		$("input", name: "_action_delete").click()} == "Are you sure?"
	}
   
Then(~/^Eu nao visualizo mais o ponto na pagina de listagem$/) { ->
    at ColetaDeletePage
}

Given(~/^O sistema possui o ponto de coleta com nome "(.*?)"$/) { String nome ->
	ColetaTestDataAndOperations.createColeta(nome, "20/09/1996", "2001")
	coleta = Coleta.findByNome(nome)
	assert coleta != null
    }

When(~/^Eu deleto o ponto de coleta com nome "(.*?)"$/) { String nome ->
	coleta = Coleta.findByNome(nome)
	ColetaTestDataAndOperations.deleteColeta(coleta)
}

Then(~/^O sistema nao possui mais o ponto de coleta com nome "(.*?)"$/) { String nome ->
	coleta = Coleta.findByNome(nome)
	assert coleta != null   
}