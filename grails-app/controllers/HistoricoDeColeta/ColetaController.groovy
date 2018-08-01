package HistoricoDeColeta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ColetaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Coleta.list(params), model:[coletaInstanceCount: Coleta.count()]
    }

    def show(Coleta coletaInstance) {
        respond coletaInstance
    }

    def create() {
        respond new Coleta(params)
    }

    @Transactional
    def save(Coleta coletaInstance) {
        if (coletaInstance == null) {
            notFound()
            return
        }

        if (coletaInstance.hasErrors()) {
            respond coletaInstance.errors, view:'create'
            return
        }

        coletaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'coleta.label', default: 'Coleta'), coletaInstance.id])
                redirect coletaInstance
            }
            '*' { respond coletaInstance, [status: CREATED] }
        }
    }

    def edit(Coleta coletaInstance) {
        respond coletaInstance
    }

    @Transactional
    def update(Coleta coletaInstance) {
        if (coletaInstance == null) {
            notFound()
            return
        }

        if (coletaInstance.hasErrors()) {
            respond coletaInstance.errors, view:'edit'
            return
        }

        coletaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Coleta.label', default: 'Coleta'), coletaInstance.id])
                redirect coletaInstance
            }
            '*'{ respond coletaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Coleta coletaInstance) {

        if (coletaInstance == null) {
            notFound()
            return
        }

        coletaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Coleta.label', default: 'Coleta'), coletaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'coleta.label', default: 'Coleta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[coletaInstanceList: Coleta.list(params), coletaInstanceTotal: Coleta.count()]
	}
	//lisGroupByVolume
	def totalVolume() {
		def listaGeralDeColetas = Coleta.list(params)
		def totalVolume = 0
		
		listaGeralDeColetas.each {
			totalVolume += it.volume 
		}
		
		[coletaTotal : totalVolume]
	}
}
