package steps

import HistoricoDeColeta.*
import cucumber.api.Format

class HistoricoTestDataAndOperations {

    static  coletas = [

             nome:"RU",
             data: ("08/04/2015"),
             volume: 101,

    ]

    static public def getColeta(){
		Date data = new Date()
		data.parse("dd/MM/yyyy", "08/04/2015")
		return Coleta.findByNomeAndDataColeta("RU", data)
    }


    static public void criarColeta(String rest, Date dia, int volume){
        def cont = new ColetaController()
		
        cont.params << [nome: rest, data: dia, volume: volume]
        cont.create()
        cont.saveColeta()
        cont.response.reset()
    }

    static public void editVolumeColeta(int volume,Coleta coleta){
        def colet = coleta
        colet.setVolume(volume)
        def cont =  new ColetaController()
        cont.params << colet.properties
        cont.update()
    }

    static public void editNomeColeta(String novoNome,Coleta coleta){
        def colet = coleta
        colet.setName(novoNome)
        def cont =  new ColetaController()
        cont.params << colet.properties
        cont.update()


    }

    static public void editDataColeta(@Format("dd/MM/yyyy") Date novaData,Coleta coleta){
        def colet = coleta
        colet.setDate(novaData)
        def cont =  new ColetaController()
        cont.params << colet.properties
        cont.update()


    }

    static public void deleteColeta(Coleta coleta){
        def cont = new ColetaController()
        cont.params << [id: coleta.id]
        cont.request.setContent(new byte[1000])
        cont.delete()
        cont.response.reset()
    }


}
