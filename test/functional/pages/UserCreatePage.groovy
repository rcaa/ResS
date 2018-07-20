package pages

import java.util.LinkedHashMap;
import geb.Page

class UserCreatePage extends Page {


	def titulo = "Create User"
	static url = "/ResS/user/create"


	static at = {
		title ==~ titulo
	}
	def preencherCampos(String nome, String endereco , String usuario, String senha){
       $("form").name = nome
       $("form").address = endereco
       $("form").login = usuario
       $("form").password = senha
   

   }
	def submitCreate(){
		$("input", name: "create").click()
	}

}

