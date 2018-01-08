package pages
import geb.Page

class ColetaEditPage extends Page{

    def titulo = "Coleta List"
    static url = "ResS/coleta/edit/1"

    static at = {
        title ==~ titulo
    }
    def fillVolume(int vol){
        $("form").volume = vol
    }
	
	def fillAddressField(String address){
		$("form").addressGenerator = address
	}
	
    def fillOtherFields() {
        $("form").nome = "RU"
        $("form").data_day = "8"
        $("form").data_month = "4"
        $("form").data_year = "2015"
    }
    def submitChanges(){
        $("input", name: "_action_update").click()
    }
	def deleteColeta(){
		$("input", name: "_action_delete").click()
	}
	def boolean hasMessage(){
		def message = $('.message')

		if(!message){
			return false
		} else {
			return true
		}
	}

}