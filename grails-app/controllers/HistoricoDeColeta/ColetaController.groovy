package HistoricoDeColeta

import org.springframework.dao.DataIntegrityViolationException

class ColetaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [coletaInstanceList: Coleta.list(params), coletaInstanceTotal: Coleta.count()]
    }
	def listGroupBySize(){
		def listaGeral = Coleta.list(params)
		
		def listaAgrupada = [:]
		listaGeral.each{
			if(listaAgrupada.containsKey(it.volume)){
				listaAgrupada[it.volume]['nome'] += it.nome
				listaAgrupada[it.volume]['coletaCount'] += 1
				
			}else{
			listaAgrupada[it.volume] = ['volume':it.volume , 'coletaCount':1]
				}
			}
		[coletaInstanceList: listaAgrupada.values(), coletaInstanceTotal: listaAgrupada.size()]
		}

    def create() {
        [coletaInstance: new Coleta(params)]
    }

    def save() {
        Coleta a = new Coleta(params)
        if(Coleta.findByNomeAndDataColeta(a.nome,a.dataColeta) == null){
			def coletaInstance = new Coleta(params)

			if (!coletaInstance.save(flush: true)) {
				render(view: "create", model: [coletaInstance: coletaInstance])
				return
			}
		
			getDefaultMessageForColeta(coletaInstance, "show", 'default.created.message')

        }
    }
	
	def saveColeta(){
		save()
	}

    def show(Long id) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
			getDefaultMessageForColeta(coletaInstance, "list", 'default.not.found.message')
        }

        [coletaInstance: coletaInstance]
    }
	
    def edit(Long id) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
			getDefaultMessageForColeta(coletaInstance, "list", 'default.not.found.message')
		
        }

        [coletaInstance: coletaInstance]
    }

    def update(Long id, Long version) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
			getDefaultMessageForColeta(coletaInstance, "list", 'default.not.found.message')
        }

        if (version != null) {
            if (coletaInstance.version > version) {
                coletaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'coleta.label', default: 'Coleta')] as Object[],
                          "Another user has updated this Coleta while you were editing")
                render(view: "edit", model: [coletaInstance: coletaInstance])
                return
            }
        }

        coletaInstance.properties = params

        if (!coletaInstance.save(flush: true)) {
            render(view: "edit", model: [coletaInstance: coletaInstance])
            return
        }
		getDefaultMessageForColeta(coletaInstance, "show", 'default.updated.message')
    }
	
	def getDefaultColetaMessage(){
		flash.message = message(code: 'default.deleted.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
		redirect(action: "list")
	}

    def delete(Long id) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
            getDefautlColetaMessage()
            return
        }

        try {
            coletaInstance.delete(flush: true)
            getDefaultColetaMessage()
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def getDefaultMessageForColeta(Coleta coletaInstance, String action, String code ){
		
		if (coletaInstance != null){
			flash.message = message(code: code, args: [message(code: 'coleta.label', default: 'Coleta'), coletaInstance.id])
			redirect(action: action, id: coletaInstance.id)
			return
		}
		
		else{
			flash.message = message(code: code, args: [message(code: 'coleta.label', default: 'Coleta'), id])
			redirect(action: action)
			return
		}
	}
}
