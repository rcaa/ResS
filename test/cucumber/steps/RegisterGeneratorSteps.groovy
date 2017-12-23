package steps

import pages.GeneratorCreatePage
import residueGenerator.ResidueGenerator
import static cucumber.api.groovy.EN.*

/**
 * Created by Arthur on 01/05/2015.
 */

Given(~'^The system has no generator with the cnpj "([^"]*)"$') { String cnpj ->
    generator = ResidueGenerator.findByCnpj(cnpj)
    assert generator == null
}

When(~'I register a different generator of residue with the address "([^"]*)"$'){ String address ->
    GeneratorTestDataAndOperations.createAltGenerator(address)


}

When (~'^I register a new generator of residue with the address "([^"]*)" and cnpj "([^"]*)"$'){String address, String cnpj ->
	GeneratorTestDataAndOperations.criarGerador("Lucinha Refeicoes", "Restaurante", address, 20, 500, cnpj)
}

Given (~'^The system has a generator with the address "([^"]*)" already stored$$'){String address ->
    endereco = address
    GeneratorTestDataAndOperations.createGenerator(address)

}

Then (~'^The new residue generator is properly stored by the system$'){ ->
    assert ResidueGenerator.findByAddressGenerator(endereco) != null
}


Given(~'^I am at the register new generator page$'){ ->

    to GeneratorCreatePage
    at GeneratorCreatePage

}

When(~'^I fill the generator details with the address "([^"]*)"$'){String address ->
    GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
    LinkedHashMap generator = GTDO.findGeneratorByAddress(address);
    page.fillGeneratorDetails(generator)
}

And(~'^I register the new generator$'){ ->
    page.selectCreateGenerator()
}

Then (~'^I should see a message indicating that the action was successful$'){ ->
    assert page.readFlashMessage() != null
}

Then (~'^The new residue generator is not stored twice by the system$') { ->
    generator = ResidueGenerator.findByAddressGenerator("Bubble Street number 7")
    assert generator.nameGenerator != "Alt"
}

When (~'^I register a different generator with the address "([^"]*)"$'){ String address ->
    to GeneratorCreatePage
    GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
    LinkedHashMap generator = GTDO.getAltGenerator(address);
    page.fillGeneratorDetails(generator)
}

Then(~'^I should see an error message$'){ ->
    assert page.hasErrors()
}

When (~'I register a new generator of residue with some info left incomplete$'){ ->

}

And(~'The address "([^"]*)"$'){ String address ->
	endereco = address
    GeneratorTestDataAndOperations.createIncompleteGenerator(address)
}

Then(~'^The new residue generator with cnpj "([^"]*)" is not stored by the system$'){ String cnpj ->
    assert ResidueGenerator.findByCnpj(cnpj) == null
}

When(~'I fill the generator details with some fields left incomplete$'){->
    to GeneratorCreatePage
    GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
    LinkedHashMap generator = GTDO.getGenerator();
    page.fillGeneratorDetailsIncomplete(generator)

}
