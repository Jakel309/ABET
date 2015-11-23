package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class PersonService {
	
	def dataSource

	//Returns the name of a role given the id of the role
    def translateRole(id) {
		def sql=new Sql(dataSource)
		def rows = sql.rows("""select r.authority from role r, person_role pr where pr.person_id=? and pr.role_id=r.id""",id)
		return rows["AUTHORITY"][0]
    }
	
	//Gets all person from the database with username and id returns the rows
	def getPersons(){
		def sql =new Sql(dataSource)
		def rows=sql.rows("""select id, username from person""")
		return rows
	}
	
	//Returns the username of a person given an id
	def translatePerson(int id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select username from person where id=?""",id)
		return rows[0]['USERNAME']
	}
}
