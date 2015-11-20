package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class RoleService {
	
	def dataSource

    def getRoles() {
		def sql=new Sql(dataSource)
		def rows = sql.rows("""select id, authority from role order by id""")
		return rows
    }
	
	def hasRole(id){
		def sql=new Sql(dataSource)
		def rows = sql.rows("""select r.authority from role r, person_role pr where pr.person_id=? and pr.role_id=r.id""",id)
		return rows["AUTHORITY"][0]
	}
	
	def getRoleById(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select authority from role where id=?""",id)
		return rows
	}
}
