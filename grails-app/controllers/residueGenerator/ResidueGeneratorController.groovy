package residueGenerator

import org.springframework.dao.DataIntegrityViolationException

class ResidueGeneratorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def searchCNPJ(){
		def residueGeneratorInstance = ResidueGenerator.findByCnpj(params.cnpj)
		
		if(residueGeneratorInstance == null){
			render(view: "searchCNPJ")
			return
		}
		

		this.flashAndRedirect('default.search.message',residueGeneratorInstance.id,"show",residueGeneratorInstance.id)
	}
	
	def flashAndRedirect(String message,int id, String action, int redirectID){
		if(redirectID != null){
			flash.message = getDefaultMessage(message, id)
			redirect(action: action, id: id)
	
		}
		else{
			flash.message = getDefaultMessage(message, id)
			redirect(action: action)
		}
	}
	
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [residueGeneratorInstanceList: ResidueGenerator.list(params), residueGeneratorInstanceTotal: ResidueGenerator.count()]
    }
	
	def listGroupByType() {
		def listaGeral = ResidueGenerator.list(params)
		
		def listaAgrupada = [:]
		listaGeral.each {
			if(listaAgrupada.containsKey(it.type)){
				listaAgrupada[it.type]['averageDailyMeals'] += it.averageDailyMeals
				listaAgrupada[it.type]['averageMonthlyMeals'] += it.averageMonthlyMeals
				listaAgrupada[it.type]['generatorCount'] += 1
			}else{
				listaAgrupada[it.type] = ['type':it.type, 'averageDailyMeals':it.averageDailyMeals, 'averageMonthlyMeals':it.averageMonthlyMeals, 'generatorCount':1]
			}
		}
		
        [residueGeneratorInstanceList: listaAgrupada.values(), residueGeneratorInstanceTotal: listaAgrupada.size()]
    }
	def listGroupByAddress(){
		def listaGeral = ResidueGenerator.list(params)
		def listaAgrupada = [:]
		listaGeral.each{
			if(listaAgrupada.containsKey(it.addressGenerator)){
				listaAgrupada[it.address]['averageDailyMeals'] += it.averageDailyMeals
				listaAgrupada[it.address]['averageMonthlyMeals'] += it.averageMonthlyMeals
				listaAgrupada[it.address]['generatorCount'] += 1
				
			}else{
			listaAgrupada[it.addressGenerator] = ['address':it.addressGenerator ,'averageDailyMeals':it.averageDailyMeals, 'averageMonthlyMeals':it.averageMonthlyMeals, 'generatorCount':1]
				}
			}
		[residueGeneratorInstanceList: listaAgrupada.values(), residueGeneratorInstanceTotal: listaAgrupada.size()]
		}

    def create() {
        [residueGeneratorInstance: new ResidueGenerator(params)]
    }

    def save() {
        def residueGeneratorInstance = new ResidueGenerator(params)
        if (!residueGeneratorInstance.save(flush: true)) {
            render(view: "create", model: [residueGeneratorInstance: residueGeneratorInstance])
            return
        }
		this.flashAndRedirect('default.created.message', residueGeneratorInstance.id,"show",null)
		
    }
	
	def saveGenerator() {
		save()
	}

    def show(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
            this.flashAndRedirect('default.not.found.message', id, "list", null)
			return
        }

        [residueGeneratorInstance: residueGeneratorInstance]
    }

    def edit(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
			this.flashAndRedirect('default.not.found.message', id, "list", null)
			return
        }

        [residueGeneratorInstance: residueGeneratorInstance]
    }

    def update(Long id, Long version) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
			this.flashAndRedirect('default.not.found.message', id, "list", null)
            return
        }

        if (version != null) {
            if (residueGeneratorInstance.version > version) {
                residueGeneratorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'residueGenerator.label', default: 'ResidueGenerator')] as Object[],
                          "Another user has updated this ResidueGenerator while you were editing")
                render(view: "edit", model: [residueGeneratorInstance: residueGeneratorInstance])
                return
            }
        }

        residueGeneratorInstance.properties = params

        if (!residueGeneratorInstance.save(flush: true)) {
            render(view: "edit", model: [residueGeneratorInstance: residueGeneratorInstance])
            return
        }
		this.flashAndRedirect('default.updated.message', id, "show", residueGeneratorInstance.id)
    }

	def updateGenerator(Long id, Long version) {
		update(id, version)
	}

    def delete(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
			this.flashAndRedirect('default.not.found.message', id, "list", null)
            return
        }

        try {
            residueGeneratorInstance.delete(flush: true)
			
			this.flashAndRedirect('default.deleted.message', id, "list", null)
			
        }
        catch (DataIntegrityViolationException e) {
			this.flashAndRedirect('default.deleted.message', id, "list", id)
			
        }
    }

    def deleteGenerator(Long id) {
		delete(id)
    }

	def getDefaultMessage(String code, Long id) {
		message(code: code, args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
	}
}
