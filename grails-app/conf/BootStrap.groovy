import com.ABET.Role
import com.ABET.Person
import com.ABET.PersonRole
import groovy.sql.Sql

class BootStrap {
	
	def dataSource

    def init = { servletContext ->
		
		def sql=new Sql(dataSource)
		
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

		def defaultAdmin = new Person(username: 'admin', password: 'password', roleId:1, email:'admin@acu.edu')
		def testUser = new Person(username: 'user', password:'password', roleId:2, email:'user@acu.edu')
		defaultAdmin.save(flush:true)
		testUser.save(flush: true)

		PersonRole.create testUser, userRole, true
		PersonRole.create defaultAdmin, adminRole, true
		
    }
    def destroy = {
    }
}
