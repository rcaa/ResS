package steps

import java.util.Date;

import HistoricoDeColeta.Coleta
import HistoricoDeColeta.ColetaController

class ColetaTestDataAndOperations {
	
	static  coletas = [
				nome:"RU",
				data: ("08/04/2015"),
				volume: 101,
			]
	static public def findColetaByNome(String nome ) {
		coletas.find { coleta ->
			coleta.nome == nome
		}
	}
	static public def findColetaByNomeData(String rest,String date1 ) {
		def data1 = new Date().parse("dd/MM/yyyy", date1)
		coletas.find { coleta ->
			coleta.nome == rest
			coleta.data == data1
		}
	}
	static public void createColeta(String rest,String dia, String volume){
		def cont = new ColetaController()
		def data = new Date().parse("dd/MM/yyyy", dia)
		int volumeInteiro = Integer.valueOf(volume)
		cont.params << [nome: rest, data: data, volume: volumeInteiro]
		cont.createAndSave()
		cont.save()
		cont.response.reset()
	}
	static public void deleteColeta(Coleta coleta){
        def cont = new ColetaController()
        cont.params << [id: coleta.id]
        cont.request.setContent(new byte[1000])
        cont.delete()
        cont.response.reset()
    }
}