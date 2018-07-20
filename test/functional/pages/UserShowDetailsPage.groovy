package pages
import geb.Page

class UserShowDetailsPage extends Page{

	def titulo = "Show User"
	static url = "/ResS/user/show/1"


	static at = {
		title ==~ titulo
	}
	

}
