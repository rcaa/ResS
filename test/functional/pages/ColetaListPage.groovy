package pages
import geb.Page

class ColetaListPage extends Page{

    def titulo = "Coleta List"
    static url = "ResS/coleta/list"
	
    static at = {
        title ==~ titulo
    }
}
