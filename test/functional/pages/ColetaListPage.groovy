package pages
import geb.Page

class ColetaListPage extends Page{

    def titulo = "Coleta List"
    static url = "http://localhost:8070/ResS/coleta/list"


    static at = {
        title ==~ titulo
    }
	

}
