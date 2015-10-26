package com.ABET



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PersonRoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PersonRole.list(params), model:[personRoleInstanceCount: PersonRole.count()]
    }

    def show(PersonRole personRoleInstance) {
        respond personRoleInstance
    }

    def create() {
        respond new PersonRole(params)
    }

    @Transactional
    def save(PersonRole personRoleInstance) {
        if (personRoleInstance == null) {
            notFound()
            return
        }

        if (personRoleInstance.hasErrors()) {
            respond personRoleInstance.errors, view:'create'
            return
        }

        personRoleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'personRole.label', default: 'PersonRole'), personRoleInstance.id])
                redirect(action:'index')
            }
            '*' { respond personRoleInstance, [status: CREATED] }
        }
    }

    def edit(PersonRole personRoleInstance) {
        respond personRoleInstance
    }

    @Transactional
    def update(PersonRole personRoleInstance) {
        if (personRoleInstance == null) {
            notFound()
            return
        }

        if (personRoleInstance.hasErrors()) {
            respond personRoleInstance.errors, view:'edit'
            return
        }

        personRoleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PersonRole.label', default: 'PersonRole'), personRoleInstance.id])
                redirect(action:'index')
            }
            '*'{ respond personRoleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PersonRole personRoleInstance) {

        if (personRoleInstance == null) {
            notFound()
            return
        }

        personRoleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PersonRole.label', default: 'PersonRole'), personRoleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personRole.label', default: 'PersonRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
