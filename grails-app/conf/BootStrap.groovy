import harvestCompany.HarvestCompany
import residueGenerator.ResidueGenerator

class BootStrap {

    def init = { servletContext ->
        def ru = new ResidueGenerator(
                nameGenerator:"RU",
                type: "Restaurante",
                cnpj: "testecnpj1",
                addressGenerator: "Bubble road number 4",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )



        def stockHarvestCompany1 = new HarvestCompany(name: "Garbage Co")
        def stockHarvestCompany2 = new HarvestCompany( name: "Reciclatron")
        def stockHarvestCompany3 = new HarvestCompany( name: "Clean Planet")

        def stockResidueGenerator = new ResidueGenerator(
                nameGenerator: "Stock Food",
                type: "Restaurante",
                cnpj: "0000000",
                addressGenerator: "Elm Street number 13",
                averageDailyMeals: 30,
                averageMonthlyMeals: 1000,
                hasActiveHarvest: false,
                harvestSolicitation: null
        )

        def stockResidueGenerator2 = new ResidueGenerator(
                nameGenerator: "Nuka Cola",
                type: "Restaurante",
                cnpj: "0000000",
                addressGenerator: "Elm Street number 14",
                averageDailyMeals: 20,
                averageMonthlyMeals: 1000,
                hasActiveHarvest: false,
                harvestSolicitation: null
        )
		
		def stockResidueGenerator3 = new ResidueGenerator(
			nameGenerator: "Nuka Cola",
			type: "Restaurante",
			cnpj: "35401447000157",
			addressGenerator: "Elm Street number 15",
			averageDailyMeals: 20,
			averageMonthlyMeals: 1000,
			hasActiveHarvest: false,
			harvestSolicitation: null
		)
		
		def stockResidueGenerator4 = new ResidueGenerator(
			nameGenerator: "Boa Vista",
			type: "Restaurante",
			cnpj: "35401447000157",
			addressGenerator: "Elm Street number 16",
			averageDailyMeals: 20,
			averageMonthlyMeals: 1000,
			hasActiveHarvest: false,
			harvestSolicitation: null
		)



		def stockResidueGenerator3 = new ResidueGenerator(
			nameGenerator: "Nuka Cola",
			type: "Restaurante",
			cnpj: "35401447000157",
			addressGenerator: "Elm Street number 15",
			averageDailyMeals: 20,
			averageMonthlyMeals: 1000,
			hasActiveHarvest: false,
			harvestSolicitation: null
		)
		
		def stockResidueGenerator4 = new ResidueGenerator(
			nameGenerator: "Boa Vista",
			type: "Restaurante",
			cnpj: "35401447000157",
			addressGenerator: "Elm Street number 16",
			averageDailyMeals: 20,
			averageMonthlyMeals: 1000,
			hasActiveHarvest: false,
			harvestSolicitation: null
		)


        ru.save(failOnError: true)
        stockResidueGenerator.save(failOnError: true)
        stockResidueGenerator2.save(failOnError: true)
		stockResidueGenerator3.save(failOnError: true)
		stockResidueGenerator4.save(failOnError: true)
        stockHarvestCompany1.save(failOnError: true);
        stockHarvestCompany2.save(failOnError: true);
        stockHarvestCompany3.save(failOnError: true);

        def area2 = new ResidueGenerator(
                nameGenerator:"CCEN/Area II",
                type: "Cantina",
                cnpj: "testecnpj2",
                addressGenerator: "UFPE1",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        area2.save(failOnError: true)

        def bomCafe = new ResidueGenerator(
                nameGenerator:"Bom Cafe – CTG",
                type: "Restaurante",
                cnpj: "testecnpj3",
                addressGenerator: "UFPE2",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        bomCafe.save(failOnError: true)
        def rotadoLanche = new ResidueGenerator(
                nameGenerator:"Rota do Lanche",
                type: "Restaurante",
                cnpj: "testecnpj4",
                addressGenerator: "UFPE3",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        rotadoLanche.save(failOnError: true)

        def cantinaCssa = new ResidueGenerator(
                nameGenerator:"Cantina CCSA",
                type: "Cantina",
                cnpj: "testecnpj5",
                addressGenerator: "UFPE4",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        cantinaCssa.save(failOnError: true)
        def quiosqueCssa = new ResidueGenerator(
                nameGenerator:"Quiosque CCSA",
                type: "Cantina",
                cnpj: "testecnpj6",
                addressGenerator: "UFPE5",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        quiosqueCssa.save(failOnError: true)

        def planetRefeicoesCTG = new ResidueGenerator(
                nameGenerator:"Planet Refeicoes – CTG",
                type: "Restaurante",
                cnpj: "testecnpj7",
                addressGenerator: "UFPE6",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        planetRefeicoesCTG.save(failOnError: true)

        def planetRefeicoesCCS = new ResidueGenerator(
                nameGenerator:"Planet Refeicoes – CCS",
                type: "Restaurante",
                cnpj: "testecnpj8",
                addressGenerator: "UFPE7",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        planetRefeicoesCCS.save(failOnError: true)
        def planetRefeicoesCE = new ResidueGenerator(
                nameGenerator:"Planet Refeicoes – CE",
                type: "Restaurante",
                cnpj: "testecnpj9",
                addressGenerator: "UFPE8",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        planetRefeicoesCE.save(failOnError: true)
        def chefPlataoCCSA = new ResidueGenerator(
                nameGenerator:"Chef Platão – CCSA",
                type: "Restaurante",
                cnpj: "testecnpj10",
                addressGenerator: "UFPE9",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        chefPlataoCCSA.save(failOnError: true)

        def chefPlataoCFCH = new ResidueGenerator(
                nameGenerator:"Chef Platao – CFCH",
                type: "Restaurante",
                cnpj: "testecnpj11",
                addressGenerator: "UFPE10",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        chefPlataoCFCH.save(failOnError: true)
        def aquarela = new ResidueGenerator(
                nameGenerator:"Aquarela - CAC",
                type: "Restaurante",
                cnpj: "testecnpj12",
                addressGenerator: "UFPE11",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        aquarela.save(failOnError: true)

        def sinhaPimenta = new ResidueGenerator(
                nameGenerator:"Sinha Pimenta – CCB",
                type: "Restaurante",
                cnpj: "testecnpj13",
                addressGenerator: "UFPE12",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        sinhaPimenta.save(failOnError: true)

    }
    def destroy = {
    }
}
