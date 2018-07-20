package pages
import geb.Page
class LoginPage extends Page {


	def titulo = "ResS - login"
	static url = "/ResS/home/login"

	static at = {
		title ==~ titulo
	}
	def selectLogin(){
        $("input", name: "Login" ).click()
    }
	
	
}
