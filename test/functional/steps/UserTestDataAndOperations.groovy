package steps

import java.util.Date;

import user.*
import cucumber.api.Format

class UserTestDataAndOperations {

	
	static public void creatUser(int id, String nome, String endereco, String login, String senha ){
		if(nome != "" && endereco != "" && login != "" && senha != "") {
			def user = new UserController()
		
			user.params << [id: id,
							name: nome, 
							address: endereco,
							login: login,
							password: senha]
			user.create()
			user.saveUser()
			user.response.reset()
		}
   }
}