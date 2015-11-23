package com.ABET

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class WorksheetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	def worksheetService
	def rubricService
	def worksheetQuestionsService
	
	//This function is used to send data to the index page to display
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Worksheet.list(params), model:[worksheetInstanceCount: Worksheet.count()]
    }
	
	//This function is used for the show page, though that page is never displayed to the user
	def displayResults(int w_id){
		def r_id=worksheetService.getRubricId(w_id)
		Map ws_results=worksheetService.getWorksheetAnswers(w_id)
		def r_rows=rubricService.getRubricQuestions(r_id)
		def w_rows=worksheetQuestionsService.getWorksheetQuestions()
		Map r_results=rubricService.getResults(w_id)
		render (view:'displayResults', model:[questions:r_rows, r_id:r_id, w_id:w_id, w_questions:w_rows, ws_results:ws_results, r_results:r_results])
	}

	//This function is used for the show page, though that page is never displayed to the user
    def show(Worksheet worksheetInstance) {
        respond worksheetInstance
    }

	//This function is used to send the params of a new to worksheet object to the create page
    def create() {
        respond new Worksheet(params)
    }

	//This function is used to save the params that were submitted in the create page
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

	//This function sends the data of the person object being edited to the edit page
    def edit(Worksheet worksheetInstance) {
        respond worksheetInstance
    }

	//This function is used to update the worksheet object after being edited
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

	//This function is used to delete the worksheet object that is passed into it from the delete action
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
