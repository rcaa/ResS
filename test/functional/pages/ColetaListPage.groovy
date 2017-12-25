package pages
import java.util.Date;

import geb.Page

class ColetaListPage extends Page{

    def titulo = "Coleta List"
    static url = "/ResS/coleta/list"


    static at = {
        title ==~ titulo
    }

	def encontrarNaPaginaNomeDataVolume(String nome, Date dia, int volume){
		def html = $('html').getAttribute("innerHTML")
		assert html.contains(nome)
		assert html.contains(dia.format("dd/MM/yyyy HH:mm:ss")) ||
		       html.contains(dia.format("yyyy-MM-dd HH:mm:ss"))
		assert html.contains(''+volume)
	}


}
