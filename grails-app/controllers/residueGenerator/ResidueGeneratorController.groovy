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
		
		flash.message = getDefaultMessage('default.search.message', residueGeneratorInstance.id)
		redirect(action: "show", id: residueGeneratorInstance.id)
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

		flash.message = getDefaultMessage('default.created.message', residueGeneratorInstance.id)
        redirect(action: "show", id: residueGeneratorInstance.id)
    }
	
	def saveGenerator() {
		save()
	}

    def show(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
			flash.message = getDefaultMessage('default.not.found.message', id)
            redirect(action: "list")
            return
        }

        [residueGeneratorInstance: residueGeneratorInstance]
    }

    def edit(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
			flash.message = getDefaultMessage('default.not.found.message', id)
            redirect(action: "list")
            return
        }

        [residueGeneratorInstance: residueGeneratorInstance]
    }

    def update(Long id, Long version) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
			flash.message = getDefaultMessage('default.not.found.message', id)
            redirect(action: "list")
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

		flash.message = getDefaultMessage('default.updated.message', id)
        redirect(action: "show", id: residueGeneratorInstance.id)
    }

	def updateGenerator(Long id, Long version) {
		update(id, version)
	}

    def delete(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
			flash.message = getDefaultMessage('default.not.found.message', id)
            redirect(action: "list")
            return
        }

        try {
            residueGeneratorInstance.delete(flush: true)
			flash.message = getDefaultMessage('default.deleted.message', id)
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = getDefaultMessage('default.not.deleted.message', id)
            redirect(action: "show", id: id)
        }
    }

    def deleteGenerator(Long id) {
		delete(id)
    }

	def getDefaultMessage(String code, Long id) {
		message(code: code, args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
	}
}
