package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class PersonService {
	
	def dataSource

    def translateRole(id) {
		def sql=new Sql(dataSource)
		def rows = sql.rows("""select r.authority from role r, person_role pr where pr.person_id=? and pr.role_id=r.id""",id)
		return rows["AUTHORITY"][0]
    }
	
	def getPersons(){
		def sql =new Sql(dataSource)
		def rows=sql.rows("""select id, username from person""")
		return rows
	}
	
	def translatePerson(int id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select username from person where id=?""",id)
		return rows[0]['USERNAME']
	}
}
