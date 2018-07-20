package steps

import residueGenerator.ResidueGenerator
import residueGenerator.HarvestSolicitation
import residueGenerator.GeneratorHarvestSolicitationController
import residueGenerator.ResidueGeneratorController

class CreateHarvestSolicitationTestDataAndOperations {

    static generators = [
            [
                    nameGenerator: "Nuka Cola",
                    type: "Restaurante",
                    cnpj: "0000000",
                    addressGenerator: "Elm Street number 13",
                    averageDailyMeals: 30,
                    averageMonthlyMeals: 1000,
                    hasActiveHarvest: false,
                    harvestSolicitation: null
            ]
    ]



    static harvestSolicitations =[
            [
                    harvesterId:3,
                    generatorId:2,
                    status: "Pending",
                    estimatedAmountOfResidue: 30,
                    solicitationDate: new Date(),
                    residueGenerator: findGeneratorByAddress("Elm Street number 13")
            ]
    ]


    static public def findGeneratorByAddress(String address) {
        generators.find { generator ->
            generator.addressGenerator == address
        }
    }
    static public def findHarvestByAmount(String amount) {
        int amountNumber =  amount.toInteger();
        harvestSolicitations.find { harvest ->
            harvest.estimatedAmountOfResidue == amountNumber
        }
    }

    static public void createGenerator(String address){
        def cont = new ResidueGeneratorController()
        def novoGenerator = findGeneratorByAddress(address)
        cont.params << novoGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void createHarvestSolicitation(String amount){
        def cont = new GeneratorHarvestSolicitationController()
        def newHarvest = findHarvestByAmount(amount)
        cont.params << newHarvest
        cont.save()
        cont.response.reset()
    }
}
