package com.ABET

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProgramController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		println Program.list(params)
        respond Program.list(params), model:[programInstanceCount: Program.count()]
    }

    def show(Program programInstance) {
        respond programInstance
    }

    def create() {
        respond new Program(params)
    }

    @Transactional
    def save(Program programInstance) {
        if (programInstance == null) {
            notFound()
            return
        }

        if (programInstance.hasErrors()) {
            respond programInstance.errors, view:'create'
            return
        }

        programInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'program.label', default: 'Program'), programInstance.id])
                redirect (action:'index')
            }
            '*' { respond programInstance, [status: CREATED] }
        }
    }

    def edit(Program programInstance) {
        respond programInstance
    }

    @Transactional
    def update(Program programInstance) {
        if (programInstance == null) {
            notFound()
            return
        }

        if (programInstance.hasErrors()) {
            respond programInstance.errors, view:'edit'
            return
        }

        programInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Program.label', default: 'Program'), programInstance.id])
                redirect (action:'index')
            }
            '*'{ respond programInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Program programInstance) {

        if (programInstance == null) {
            notFound()
            return
        }

        programInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Program.label', default: 'Program'), programInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'program.label', default: 'Program'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
