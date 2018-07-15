package steps

import user.User;
import user.UserController;

class UserTestDataAndOperations{
	
	static public void criarUser(int id, String nome, String endereco, String login, String senha){
		def controller = new UserController()
		controller.params << [id: id, 
							  name: nome,
							  address: endereco,
							  login: login,
							  password: senha]
		controller.create()
		controller.saveUser()
		controller.response.reset()
	}
	
	static public void deleteUser(User user){
		def controller = new UserController()
		controller.delete(user.id)
		controller.response.reset()
	}
}