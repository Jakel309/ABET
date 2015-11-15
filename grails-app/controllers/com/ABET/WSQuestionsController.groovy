package com.ABET



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WSQuestionsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond WSQuestions.list(params), model:[WSQuestionsInstanceCount: WSQuestions.count()]
    }

    def show(WSQuestions WSQuestionsInstance) {
        respond WSQuestionsInstance
    }

    def create() {
        respond new WSQuestions(params)
    }

    @Transactional
    def save(WSQuestions WSQuestionsInstance) {
        if (WSQuestionsInstance == null) {
            notFound()
            return
        }

        if (WSQuestionsInstance.hasErrors()) {
            respond WSQuestionsInstance.errors, view:'create'
            return
        }

        WSQuestionsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'WSQuestions.label', default: 'WSQuestions'), WSQuestionsInstance.id])
                redirect (action:'index')
            }
            '*' { respond WSQuestionsInstance, [status: CREATED] }
        }
    }

    def edit(WSQuestions WSQuestionsInstance) {
        respond WSQuestionsInstance
    }

    @Transactional
    def update(WSQuestions WSQuestionsInstance) {
        if (WSQuestionsInstance == null) {
            notFound()
            return
        }

        if (WSQuestionsInstance.hasErrors()) {
            respond WSQuestionsInstance.errors, view:'edit'
            return
        }

        WSQuestionsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'WSQuestions.label', default: 'WSQuestions'), WSQuestionsInstance.id])
                redirect (action:'index')
            }
            '*'{ respond WSQuestionsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(WSQuestions WSQuestionsInstance) {

        if (WSQuestionsInstance == null) {
            notFound()
            return
        }

        WSQuestionsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'WSQuestions.label', default: 'WSQuestions'), WSQuestionsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'WSQuestions.label', default: 'WSQuestions'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
