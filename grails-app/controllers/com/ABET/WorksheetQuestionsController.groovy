package com.ABET

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class WorksheetQuestionsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	//This function is used to send data to the index page to display
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		println WorksheetQuestions.list(params)
        respond WorksheetQuestions.list(params), model:[worksheetQuestionsInstanceCount: WorksheetQuestions.count()]
    }

	//This function is used for the show page, though that page is never displayed to the user
    def show(WorksheetQuestions worksheetQuestionsInstance) {
        respond worksheetQuestionsInstance
    }

	//This function is used to send the params of a new to worksheet question object to the create page
    def create() {
        respond new WorksheetQuestions(params)
    }

	//This function is used to save the params that were submitted in the create page
    @Transactional
    def save(WorksheetQuestions worksheetQuestionsInstance) {
        if (worksheetQuestionsInstance == null) {
            notFound()
            return
        }

        if (worksheetQuestionsInstance.hasErrors()) {
            respond worksheetQuestionsInstance.errors, view:'create'
            return
        }

        worksheetQuestionsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'worksheetQuestions.label', default: 'worksheetQuestions'), worksheetQuestionsInstance.id])
                redirect (action:'index')
            }
            '*' { respond worksheetQuestionsInstance, [status: CREATED] }
        }
    }

	//This function sends the data of the person object being edited to the edit page
    def edit(WorksheetQuestions worksheetQuestionsInstance) {
        respond worksheetQuestionsInstance
    }

	//This function is used to update the worksheet question object after being edited
    @Transactional
    def update(WorksheetQuestions worksheetQuestionsInstance) {
        if (worksheetQuestionsInstance == null) {
            notFound()
            return
        }

        if (worksheetQuestionsInstance.hasErrors()) {
            respond worksheetQuestionsInstance.errors, view:'edit'
            return
        }

        worksheetQuestionsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'worksheetQuestions.label', default: 'worksheetQuestions'), worksheetQuestionsInstance.id])
                redirect (action:'index')
            }
            '*'{ respond worksheetQuestionsInstance, [status: OK] }
        }
    }

	//This function is used to delete the worksheet questions object that is passed into it from the delete action
    @Transactional
    def delete(WorksheetQuestions worksheetQuestionsInstance) {

        if (worksheetQuestionsInstance == null) {
            notFound()
            return
        }

        worksheetQuestionsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'worksheetQuestions.label', default: 'worksheetQuestions'), worksheetQuestionsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'worksheetQuestions.label', default: 'worksheetQuestions'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
