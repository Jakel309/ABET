package com.ABET

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import com.ABET.PersonRole
import com.ABET.Role
import com.ABET.Person
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PersonController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def roleService
	def personService
	def personRoleService
	def programService

	//Calls roleService to get all roles and return them
	def getRoles(){
		return roleService.getRoles()
	}
	
	//Returns the name of the role specified by id
	def translateRole(id){
		return personService.translateRole(id)
	}
	
	//Returns a list of all programs and ids
	def getPrograms(){
		programService.getPrograms()
	}
	
	//Returns a list of all persons
	def getPersons(){
		personService.getPersons()
	}
	
	//Returns the username of a person given an id
	def translatePerson(id){
		personService.translatePerson(id)
	}
	
	//This function is used to send data to the index page to display
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Person.list(params), model:[personInstanceCount: Person.count()]
    }

	//This function is used for the show page, though that page is never displayed to the user
    def show(Person personInstance) {
        respond personInstance
    }

	//This function is used to send the params of a new to person object to the create page
    def create() {
        respond new Person(params)
    }

	//This function is used to save the params that were submitted in the create page
    @Transactional
    def save(Person personInstance) {
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'create'
            return
        }

        //personInstance.save flush:true

		def newUser=new Person(username: personInstance.username, password: personInstance.password, roleId:personInstance.roleId, email:personInstance.email).save(flush:true)
		def role=Role.findByAuthority(roleService.getRoleById(personInstance.roleId)[0][0])
		println newUser
		println "The following are println"
		println role
		println "Second Role"
		println roleService.getRoleById(personInstance.roleId)[0][0]
		PersonRole.create newUser,role, true
		
        request.withFormat {
            form multipartForm {
				//personRoleService.createPR(personInstance.id, personInstance.roleId)
                flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), personInstance.username])
                redirect (action:'index')
            }
            '*' { respond personInstance, [status: CREATED] }
        }
    }

	//This function sends the data of the person object being edited to the edit page
    def edit(Person personInstance) {
        respond personInstance
    }

	//This function is used to update the person object after being edited
    @Transactional
    def update(Person personInstance) {
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'edit'
            return
        }

        personInstance.save flush:true
		
		personRoleService.updatePR(personInstance.id, personInstance.roleId)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect (action:'index')
            }
            '*'{ respond personInstance, [status: OK] }
        }
    }

	//This function is used to delete the person object that is passed into it from the delete action
    @Transactional
    def delete(Person personInstance) {

        if (personInstance == null) {
            notFound()
            return
        }

        personInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
