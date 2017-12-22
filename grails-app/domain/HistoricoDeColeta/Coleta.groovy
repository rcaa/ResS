package HistoricoDeColeta

import cucumber.api.Format

class Coleta {

    String nome // nome do estabelecimento
    Date data // data da coleta
    int volume // volume coletado


    static constraints = {

        nome blank: true // no caso de ser ecoponto pode não ter nome
        data blank: false, nullable: false, min: new Date()
        volume  blank: false, nullable: false, min:1
    
	}
	
    void setName(String novoNome){
        if(Coleta.findByNomeAndData(novoNome,this.data) == null){
            this.nome = novoNome
        }
    }

    void setDate(@Format("dd/MM/yyyy")Date novaData){
        if(Coleta.findByNomeAndData(this.nome,novaData) == null){
            this.data = novaData
        }
    }
	
	@Override
	public String toString(){
		return "nome: $nome, data: $data, volume: $volume"
	}
}
