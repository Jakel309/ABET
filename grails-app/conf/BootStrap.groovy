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

		def defaultAdmin = new Person(username: 'admin', password: 'password', roleId:1)
		def testUser = new Person(username: 'user', password:'password', roleId:2)
		defaultAdmin.save(flush:true)
		testUser.save(flush: true)

		PersonRole.create testUser, userRole, true
		PersonRole.create defaultAdmin, adminRole, true
		
		sql.execute("""create table if not exists rubric(id int AUTO_INCREMENT NOT NULL, name varchar(255) unique, num_ques int, primary key(id))""")
		sql.execute("""create table if not exists questions(id int AUTO_INCREMENT NOT NULL, question varchar(255) unique, primary key(id))""")
		sql.execute("""create table if not exists rubric_questions(r_id int NOT NULL, q_id int NOT NULL, foreign key(r_id) references rubric(id), foreign key(q_id) references questions(id))""")
		sql.execute("""create table if not exists results(id int AUTO_INCREMENT NOT NULL, r_id int, results mediumtext, primary key(id), foreign key(r_id) references rubric(id))""")
		
    }
    def destroy = {
    }
}
