package pages
import java.util.Date;

import geb.Page

class ColetaListPage extends Page{

    def titulo = "Coleta List"
    static url = "/ResS/coleta/list"


    static at = {
        title ==~ titulo
    }
	
	def check(String nome, Date dia, int volume){
		def listDiv = $('div', id: 'list-coleta')
		def coletaTables = listDiv.find('table')		
		def coletas = coletaTables[0].find('tbody')[0].find('tr')
		def elementosColeta = coletas[0].find('td')
		
		def nomeColeta = elementosColeta[0].find('a')[0].getAttribute("innerHTML")
		assert nomeColeta == nome
		
		def dataColeta = elementosColeta[1].getAttribute("innerHTML")
		assert dataColeta == dia.format("MM/dd/yyyy HH:mm:ss z")
		
		def volumeColeta = elementosColeta[2].getAttribute("innerHTML")
		assert Integer.parseInt(volumeColeta) == volume
	}


}
