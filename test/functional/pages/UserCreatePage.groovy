package pages
import geb.Page

class UserCreatePage extends Page {

	def titulo = "Create User"
	static url = "/ResS/user/create"

	static at = {
		title ==~ titulo
	}
}