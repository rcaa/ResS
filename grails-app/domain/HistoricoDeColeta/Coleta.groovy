package HistoricoDeColeta

import cucumber.api.Format

class Coleta {

    String nome // nome do estabelecimento
    Date dataColeta // data da coleta
    int volume // volume coletado


    static constraints = {

        nome blank: true, maxSize: 100 // no caso de ser ecoponto pode não ter nome
        dataColeta blank: false, nullable: false
        volume  blank: false, nullable: false
    }
    void setName(String novoNome){
        if(Coleta.findByNomeAndData(novoNome,this.dataColeta) == null){
            this.nome = novoNome
        }
    }

    void setDate(@Format("dd/MM/yyyy")Date novaData){
        if(Coleta.findByNomeAndData(this.nome,novaData) == null){
            this.dataColeta = novaData
        }
    }
	
	String toString() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coleta other = (Coleta) obj;
		if (dataColeta == null) {
			if (other.dataColeta != null)
				return false;
		} else if (!dataColeta.equals(other.dataColeta))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}
	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataColeta == null) ? 0 : dataColeta.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + volume;
		return result;
	}
	

}
