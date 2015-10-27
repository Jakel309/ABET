import com.ABET.Role
import com.ABET.Person
import com.ABET.PersonRole

class BootStrap {

    def init = { servletContext ->
		
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

		def defaultAdmin = new Person(username: 'admin', password: 'password', roleId:1)
		def testUser = new Person(username: 'user', password:'password', roleId:2)
		defaultAdmin.save(flush:true)
		testUser.save(flush: true)

		PersonRole.create testUser, userRole, true
		PersonRole.create defaultAdmin, adminRole, true
		
    }
    def destroy = {
    }
}
