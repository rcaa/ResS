package steps

import HistoricoDeColeta.Coleta;
import residueGenerator.ResidueGenerator
import residueGenerator.ResidueGeneratorController

class GeneratorTestDataAndOperations{

    static  generators = [

            [nameGenerator:"RU",
             type: "Restaurante",
             cnpj: "testecnpj1",
             addressGenerator: "Bubble Street number 7",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

            [nameGenerator:"Clovis Palace",
             type: "Restaurante",
             cnpj: "testecnpj2",
             addressGenerator: "Bubble Street number 4",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

            [nameGenerator:"China Dragon",
             type: "Restaurante",
             cnpj: "testecnpj3",
             addressGenerator: "Donut Street number 5",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0]
    ]

    static public def getGenerator(){
        return findGeneratorByAddress("Bubble Street number 7")
    }

    static public def findGeneratorByAddress(String address) {
        generators.find { generator ->
            generator.addressGenerator == address
        }
    }

    static public void findGeneratorByName(String name){
        generators.find {generator ->
                generator.nameGenerator == name
        }
    }
    static public void findGeneratorByCnpj(String CNPJ){
        generators.find {generator ->
            generator.cnpj== CNPJ
        }
    }
    static public void createGenerator(String address){
        def cont = new ResidueGeneratorController()
        def novoGenerator = findGeneratorByAddress(address)
        cont.params << novoGenerator as ResidueGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }
	
	static public void criarGerador(String nome, String tipo, String endereco, int mediaDiaria, int mediaMensal, String cnpj){
		def cont = new ResidueGeneratorController()
		cont.params << [nameGenerator: nome,
						type: tipo,
						cnpj: cnpj,
						addressGenerator: endereco,
						averageMonthlyMeals: mediaMensal,
						averageDailyMeals: mediaDiaria]
		cont.create()
		cont.saveGenerator()
		cont.response.reset()
	}

    static public void createGeneratorName(String name){
        def cont = new ResidueGeneratorController()
        def newGenerator = [nome: name,
                            type: "Restaurante",
                            cnpj: "testecnpj1",
                            addressGenerator: "Bubble Street number 7",
                            averageMonthlyMeals: 0,
                            averageDailyMeals: 0]
        cont.params << newGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void createGeneratorCnpj(String CNPJ){
        def cont = new ResidueGeneratorController()
        def newGenerator = [nome: "RU",
                            type: "Restaurante",
                            cnpj: CNPJ,
                            addressGenerator: "Bubble Street number 7",
                            averageMonthlyMeals: 0,
                            averageDailyMeals: 0]
        cont.params << newGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void showGenerator(String name){
        def cont = new ResidueGeneratorController()
        def newGenerator = findGeneratorByName(name)
            cont.show(newGenerator)
    }

    static public void showGeneratorByCnpj(String cnpj){
        def cont = new ResidueGeneratorController()
        def newGenerator = findGeneratorByCnpj(cnpj)
        cont.show(newGenerator)
    }

    static public void editGeneratorAddress(String address, def residueGenerator){
        if(address != null && residueGenerator != null) {
			def existingGenerator = ResidueGenerator.findByCnpj(residueGenerator.cnpj)

            def cont = new ResidueGeneratorController()
			cont.params << [nome: existingGenerator.nameGenerator,
						    type: existingGenerator.type,
						    cnpj: existingGenerator.cnpj,
						    addressGenerator: address,
						    averageMonthlyMeals: existingGenerator.averageDailyMeals,
						    averageDailyMeals: existingGenerator.averageMonthlyMeals]
            cont.updateGenerator(existingGenerator.id, existingGenerator.getVersion()+1)
            cont.response.reset()
        }
    }

    static public getAltGenerator(String address){
        def novoGenerator =  [nameGenerator: "Alt",
                              type: "Restaurante",
                              cnpj: "testecnpj1",
                              addressGenerator: address,
                              averageMonthlyMeals: 0,
                              averageDailyMeals: 0];
        return novoGenerator;
    }

    static public void createAltGenerator(String address){
        def cont = new ResidueGeneratorController()
        def novoGenerator = getAltGenerator(address)
        cont.params << novoGenerator
        cont.create()
        cont.save()
        cont.response.reset()

    }

    static public void createIncompleteGenerator(String address){
        def cont = new ResidueGeneratorController()
        cont.params << [nameGenerator: "",
                        type: "Restaurante",
                        cnpj: null,
                        addressGenerator: address,
                        averageMonthlyMeals: null,
                        averageDailyMeals: 0];
        cont.create()
        cont.save()
        cont.response.reset()
    }
	
	static public void deleteGenerator(ResidueGenerator gerador){
		def cont = new ResidueGeneratorController()
		cont.deleteGenerator(gerador.id)
		cont.response.reset()
	}

    //LIST FEATURES
    static public void createGeneratorWithDailyMeal(String address, int dailymeal){
        def cont = new ResidueGeneratorController()
        def novoGenerator = findGeneratorByAddress("Bubble Street number 7")
        cont.params << novoGenerator
        cont.params << [addressGenerator: address] << [averageDailyMeals: dailymeal]
        cont.create()
        cont.save()
        cont.response.reset()
    }


    static public boolean containResidueGenerator(String address,ResGen){
        def testresidue = ResidueGenerator.findByAddressGenerator(address)
        return ResGen.contains(testresidue)
    }

    static public boolean isSorted(Residuegenerators) {
        //def isSorted = (Residuegenerators.size() < 2 || (1..<Residuegenerators.size()).every { (Residuegenerators[it - 1].averageDailyMeals).compareTo(Residuegenerators[it].averageDailyMeals) > 0})
        def isSorted = ResidueGenerator.findAll().sort{it.averageDailyMeals}
        isSorted = isSorted.reverse()
        return ((isSorted[0].addressGenerator).equals(Residuegenerators[0].addressGenerator) && (isSorted[1].addressGenerator).equals(Residuegenerators[1].addressGenerator))
    }
    ///////


}