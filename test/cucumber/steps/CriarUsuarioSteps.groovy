package steps

import static cucumber.api.groovy.EN.*
import user.User;

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