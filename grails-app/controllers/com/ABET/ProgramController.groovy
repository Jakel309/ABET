package com.ABET

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class ProgramController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	//This function is used to send data to the index page to display
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		println Program.list(params)
        respond Program.list(params), model:[programInstanceCount: Program.count()]
    }

	//This function is used for the show page, though that page is never displayed to the user
    def show(Program programInstance) {
        respond programInstance
    }

	//This function is used to send the params of a new to program object to the create page
    def create() {
        respond new Program(params)
    }

	//This function is used to save the params that were submitted in the create page
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

	//This function sends the data of the person object being edited to the edit page
    def edit(Program programInstance) {
        respond programInstance
    }

	//This function is used to update the program object after being edited
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

	//This function is used to delete the program object that is passed into it from the delete action
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
