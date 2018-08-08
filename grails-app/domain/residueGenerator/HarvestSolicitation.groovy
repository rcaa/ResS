package residueGenerator

class HarvestSolicitation {

    int harvesterId;
    int generatorId;
    String status;
    int estimatedAmountOfResidue;
    Date solicitationDate;
    ResidueGenerator residueGenerator;

    static belongsTo = [residueGenerator : ResidueGenerator]

    static constraints = {
        harvesterId nullable:false,blank:false,unique:true
        generatorId nullable:false,blank:false,unique:true
        status nullable:false,blank:false , maxSize: 10 
        solicitationDate nullable:false,blank:false
        estimatedAmountOfResidue nullable:false,blank:false
    }
	
	String toString() {
		return "Harvest Solicitation of "+residueGenerator.nameGenerator+" on "+solicitationDate.toString()
	}
}
