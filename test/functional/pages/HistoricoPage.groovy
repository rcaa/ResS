package pages
import geb.Page


class HistoricoPage extends Page{

    def titulo = "Create Coleta"
    static url = "/ResS/coleta/create"

    static at = {

        title ==~ titulo
    }
	
	def fillColetaInfo(String volume){
		$("form").nome = "RU"
		$("form").data_day = "8"
		$("form").data_month = "4"
		$("form").data_year = "2015"
		$("form").volume = volume

	}

    def fillColetaInfo(){
        $("form").nome = "RU"
        $("form").data_day = "8"
        $("form").data_month = "4"
        $("form").data_year = "2015"
        $("form").volume = 101

    }

	def boolean hasInvalidMessage(){
		
				def invalidField = $('input:invalid')
		
				if(invalidField != null){
					return true
				} else {
					return false
				}
	}

    def selectAdicionarColeta(){
        $("input", name: "create").click()
    }

}

