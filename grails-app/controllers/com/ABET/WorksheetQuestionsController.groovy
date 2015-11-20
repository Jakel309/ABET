package com.ABET



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WorksheetQuestionsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond WorksheetQuestions.list(params), model:[worksheetQuestionsInstanceCount: WorksheetQuestions.count()]
    }

    def show(WorksheetQuestions worksheetQuestionsInstance) {
        respond worksheetQuestionsInstance
    }

    def create() {
        respond new WorksheetQuestions(params)
    }

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

    def edit(WorksheetQuestions worksheetQuestionsInstance) {
        respond worksheetQuestionsInstance
    }

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
