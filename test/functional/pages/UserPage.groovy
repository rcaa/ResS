package pages
import geb.Page

class UserPage extends Page{
	
	def titulo = "User List"
	static url = "/ResS/user/index"

	static at = {
		title ==~ titulo
	}
}
