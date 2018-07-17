package steps

import pages.HomePage
import pages.UserPage
import static cucumber.api.groovy.EN.*
import cucumber.api.Format


Given(~/^I am at the home page$/) { ->
	at HomePage
	to HomePage
}

When(~/^I go to the user page$/) { ->
	page.selectUserArea()
}

Then(~/^I see the list of all users registered in the system$/) { ->
	to UserPage
	at UserPage

}
