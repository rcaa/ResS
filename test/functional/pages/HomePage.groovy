package pages
import geb.Page
class HomePage extends Page {


    def titulo = "Residue Generator List"
    static url = "/ResS/dashboard/index"

    static at = {
        title ==~ titulo
    }

    def selectResidueGeneratorArea(){
        $('#ResidueGenerator').click();
    }

    def selectGithubRibbon(){
        $('#forkongithublink').click();
    }
	
	def listColeta(){
		$('#Coleta').click();
	}
	
	//vinicius
	def selectUserArea(){
		$('#User').click();
	}

	

}
