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

        nameGenerator nullable:true,blank:true // no caso de ser ecoponto pode n�o ter nome
        type inList: ["Restaurante","Cantina","Ecoponto"], nullable:false, blank:false
        addressGenerator blank: false, nullable: false, maxSize: 40, unique: true
        averageDailyMeals  nullable: false, min: 0,blank:false
        averageMonthlyMeals  nullable: false, min: 0,blank:false
        hasActiveHarvest nullable:false
        harvestSolicitation nullable:true
        cnpj (maxSize: 18, blank:false, nullable:false, matches:"[0-9]+")
    }

    String toString(){
        if(!nameGenerator){
            return addressGenerator
        }else{
            return nameGenerator
        }
    }
}