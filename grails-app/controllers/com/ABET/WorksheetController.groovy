package com.ABET

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WorksheetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	def worksheetService
	def rubricService
	def worksheetQuestionsService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Worksheet.list(params), model:[worksheetInstanceCount: Worksheet.count()]
    }
	
	def displayResults(int w_id){
		def r_id=worksheetService.getRubricId(w_id)
		Map ws_results=worksheetService.getWorksheetAnswers(w_id)
		def r_rows=rubricService.getRubricQuestions(r_id)
		def w_rows=worksheetQuestionsService.getWorksheetQuestions()
		Map r_results=rubricService.getResults(w_id)
		render (view:'displayResults', model:[questions:r_rows, r_id:r_id, w_id:w_id, w_questions:w_rows, ws_results:ws_results, r_results:r_results])
	}

    def show(Worksheet worksheetInstance) {
        respond worksheetInstance
    }

    def create() {
        respond new Worksheet(params)
    }

    @Transactional
    def save(Worksheet worksheetInstance) {
        if (worksheetInstance == null) {
            notFound()
            return
        }

        if (worksheetInstance.hasErrors()) {
            respond worksheetInstance.errors, view:'create'
            return
        }

        worksheetInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'worksheet.label', default: 'Worksheet'), worksheetInstance.id])
                redirect (action:'index')
            }
            '*' { respond worksheetInstance, [status: CREATED] }
        }
    }

    def edit(Worksheet worksheetInstance) {
        respond worksheetInstance
    }

    @Transactional
    def update(Worksheet worksheetInstance) {
        if (worksheetInstance == null) {
            notFound()
            return
        }

        if (worksheetInstance.hasErrors()) {
            respond worksheetInstance.errors, view:'edit'
            return
        }

        worksheetInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Worksheet.label', default: 'Worksheet'), worksheetInstance.id])
                redirect (action:'index')
            }
            '*'{ respond worksheetInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Worksheet worksheetInstance) {

        if (worksheetInstance == null) {
            notFound()
            return
        }

        worksheetInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Worksheet.label', default: 'Worksheet'), worksheetInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'worksheet.label', default: 'Worksheet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
