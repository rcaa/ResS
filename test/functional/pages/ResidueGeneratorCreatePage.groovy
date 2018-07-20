package pages
import geb.Page

class ResidueGeneratorCreatePage extends Page {

	def titulo = "Create Residue Generator"
	static url = "/ResS/residueGenerator/create"

	static at = {
		title ==~ titulo
	}

}