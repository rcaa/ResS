package steps
import java.util.LinkedHashMap;

import pages.UserCreatePage
import pages.UserShowDetailsPage
import static cucumber.api.groovy.EN.*

Given(~/^estou na pagina de criar novo usuario$/) { ->
	to UserCreatePage
	at UserCreatePage
	
}

When(~/^preencho o nome com "(.*?)", endereco "(.*?)", login "(.*?)" e senha "(.*?)"$/) { String nome, String endereco, String login, String senha ->
	page.preencherCampos(nome,endereco,login,senha)

	}

When(~/^aperto em criar$/) { ->
	page.submitCreate()
	
}

Then(~/^vejo os detalhes do usuario "(.*?)"$/) { String arg1 ->
	to UserShowDetailsPage
	at	UserShowDetailsPage
	
}
