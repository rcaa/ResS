package steps

import pages.*
import user.*
import static cucumber.api.groovy.EN.*
import cucumber.api.Format
import cucumber.*

Given(~/^The system has no user with the login "(.*?)"$/) { String login ->
	fulano = User.findByLogin(login)
    assert fulano == null
}

When(~/^I register a new user with login "(.*?)" and address "(.*?)"$/) { String login, String address ->
	UserTestDataAndOperations.creatUser(1, "FULANO", address, login, "123456")
}

Then(~/^The new user with login "(.*?)" is not stored by the system$/) { String login ->
	def usuario = User.findByLogin(login)
	assert usuario == null
}