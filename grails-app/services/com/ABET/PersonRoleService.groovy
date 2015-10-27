package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class PersonRoleService {

	def dataSource
	
    def createPR(pId, rId) {
		def sql=new Sql(dataSource)
		sql.execute("""insert into person_role values ((select id from person where id=?),(select id from role where id=?)) """,pId,rId)
    }
	
	def updatePR(pId, rId){
		def sql=new Sql(dataSource)
		sql.execute("""update person_role set role_id=? where person_id=?""",rId,pId)
	}
}
