package pages

import geb.Page


class ColetaCreatePage extends Page {

	def titulo = "Coleta Create"
	static url = "ResS/coleta/create/1"

	static at = {
		title ==~ titulo
	}
	
	def fillOtherFields() {
		$("form").nome = "RU"
		$("form").data_day = "8"
		$("form").data_month = "4"
		$("form").data_year = "2015"
		$("form").Volume = "2001"
		
	}
}
