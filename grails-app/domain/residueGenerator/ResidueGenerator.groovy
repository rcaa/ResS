package residueGenerator

class ResidueGenerator {

    String nameGenerator // nome do estabelecimento
    String type// tipo de estabelecimento
    String addressGenerator // endere�o do gerador n�o confundir...

    String cnpj
    int averageDailyMeals
    int averageMonthlyMeals

    boolean hasActiveHarvest
    HarvestSolicitation harvestSolicitation

    static  hasOne = [harvestSolicitation:HarvestSolicitation]

    static constraints = {

        nameGenerator nullable:true,blank:true, maxSize: 20 // no caso de ser ecoponto pode n�o ter nome
        type inList: ["Restaurante","Cantina","Ecoponto"], nullable:false, blank:false, maxSize: 20
        addressGenerator blank: false, nullable: false, maxSize: 40, unique: true
        averageDailyMeals  nullable: false, min: 0,blank:false
        averageMonthlyMeals  nullable: false, min: 0,blank:false
        hasActiveHarvest nullable:false
        harvestSolicitation nullable:true
        cnpj blank:false, nullable:false, maxSize: 18
    }

    String toString(){
        if(!nameGenerator){
            return addressGenerator
        }else{
            return nameGenerator
        }
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime* result+ ((addressGenerator == null) ? 0 : addressGenerator.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((nameGenerator == null) ? 0 : nameGenerator.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResidueGenerator other = (ResidueGenerator) obj;
		if (addressGenerator == null) {
			if (other.addressGenerator != null)
				return false;
		} else if (!addressGenerator.equals(other.addressGenerator))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (nameGenerator == null) {
			if (other.nameGenerator != null)
				return false;
		} else if (!nameGenerator.equals(other.nameGenerator))
			return false;
		return true;
	}
	}