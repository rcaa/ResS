package pages

/**
 * Created by danie_000 on 6/25/2015.
 */
import geb.Page

class HarvestSolicitationViewPage extends Page {
    def titulo = "Create Havest Solicitation"
    static url = "/ResS/generatorHarvestSolicitation/index/3"

    static at = {
        title ==~ titulo
    }

    def boolean hasLabel(){
        def confirmationClass = $('.labelContent')

        if(confirmationClass != null){
            return true
        } else {
            return false
        }
    }
}
