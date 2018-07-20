package pages

import geb.Page

/**
 * Created by danie_000 on 5/2/2015.
 */
class ResidueGeneratorShowPage extends Page{

    def titulo = "Show ResidueGenerator"
    static url = "residueGenerator/show/1"

    static at = {
        title ==~ titulo
    }

    def boolean hasMessage(){
        def message = $('.message')

        if(!message){
            return false
        } else {
            return true
        }
    }

	def clickEditar(){
		$("a", href: "/ResS/residueGenerator/edit/1").click()
	}

    //LIST FEATURE
    def selectListResidueGenerators(){
        $("input",name: "listResidueGenerators").click()
    }
    //
	
	def ceckLabelAddress(String label){
		
	}
}
