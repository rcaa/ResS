package steps
import pages.HomePage
import pages.LoginPage
import static cucumber.api.groovy.EN.*


Given(~/^estou na pagina de login$/) { ->
	to LoginPage
	at LoginPage
	
	
}

When(~/^eu aperto em entrar$/) { ->
	at LoginPage
	page.selectLogin()
}
Then(~/^vejo a pagina "(.*?)"$/) { String arg1 ->
	arg1.equalsIgnoreCase("ResS")
	
}