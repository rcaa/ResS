package pages

import geb.Page


class CreateHarvestSolicitationPage extends Page {

    def titulo = "Create Havest Solicitation"
    static url = "/ResS/generatorHarvestSolicitation/create/3"

     static at = {
        title ==~ titulo
    }

    def fillAmountField(String amount){
        $("form").estimatedAmountOfResidue = amount
    }

    def fillRequiredFields(){
        $("form").harvesterId = 2;
    }

    def submitChanges(){
        $("input", type: "submit").click()
    }

}
