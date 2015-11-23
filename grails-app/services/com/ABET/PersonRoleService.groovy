package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class PersonRoleService {

	def dataSource
	
	//Inserts into the foreign key table another person to role relationship
    def createPR(pId, rId) {
		def sql=new Sql(dataSource)
		sql.execute("""insert into person_role values ((select id from person where id=?),(select id from role where id=?)) """,pId,rId)
    }
	
	//Resets a person to role relationship
	def updatePR(pId, rId){
		def sql=new Sql(dataSource)
		sql.execute("""update person_role set role_id=? where person_id=?""",rId,pId)
	}
}
