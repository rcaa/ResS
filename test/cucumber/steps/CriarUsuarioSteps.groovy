package steps

import java.util.LinkedHashMap;
import user.User;
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

Given(~/^existe um usuario armazenado no sistema com nome "(.*?)" e login "(.*?)"$/) { String nome, String login ->
	UserTestDataAndOperations.criarUser(1, nome, "Rua G", login, "123456")
	
	def user = User.findByNameAndLogin(nome, login)
	assert user != null
}

When(~/^crio um usuario no sistema com nome "(.*?)", login "(.*?)" e id "(.*?)"$/) { String nome, String login, String id ->
	UserTestDataAndOperations.criarUser(id.toInteger(), nome, "Rua G", login, "123456")

}

Then(~/^existe apenas um usuario armazenado no sistema com o nome "(.*?)" e login "(.*?)"$/) { String nome, String login ->
	def usuarios = User.findAllByNameAndLogin(nome,login)
	assert usuarios.size() == 1
}

Given(~/^nao existe um usuario armazenado no sistema com nome "(.*?)" e login "(.*?)"$/) { String nome, String login ->
	def user = User.findAllByNameAndLogin(nome, login)
	assert user.size() == 0
}

