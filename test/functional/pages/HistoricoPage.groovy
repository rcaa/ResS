package pages
import geb.Page


class HistoricoPage extends Page{

    def titulo = "Create Coleta"
    static url = "/ResS/coleta/create"

    static at = {

        title ==~ titulo
    }
	
	def preencherCampos(String nome, Date dia, int volume){
		$("form").nome = nome
		$("form").data_day = dia[Calendar.DATE]
		$("form").data_month = dia[Calendar.MONTH]+1
		$("form").data_year = dia[Calendar.YEAR]
		$("form").volume = volume
	}

    def fillColetaInfo(){
        $("form").nome = "RU"
        $("form").data_day = "8"
        $("form").data_month = "4"
        $("form").data_year = "2015"
        $("form").volume = 101

    }

    def selectAdicionarColeta(){
        $("input", name: "create").click()
    }
	
	def existeMensagemFaltandoNome(){
		def contentCreateColeta = $("div", id:"create-coleta")
		
		def listasErros = contentCreateColeta.find('ul')
		assert listasErros.size() != 0
		
		def erros = listasErros[0].find('li')
		assert erros.size() != 0
		 
		assert erros[0].getAttribute("innerHTML").substring(0, 59) == "O campo [nome] da classe [class HistoricoDeColeta.Coleta] n"
	}

}

