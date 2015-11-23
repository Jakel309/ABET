package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class RoleService {
	
	def dataSource

	//Returns all roles with role id and role name
    def getRoles() {
		def sql=new Sql(dataSource)
		def rows = sql.rows("""select id, authority from role order by id""")
		return rows
    }
	
	//Returns a list of all roles that a person has given id id
	def hasRole(id){
		def sql=new Sql(dataSource)
		def rows = sql.rows("""select r.authority from role r, person_role pr where pr.person_id=? and pr.role_id=r.id""",id)
		return rows["AUTHORITY"][0]
	}
	
	//Returns a role name given the id
	def getRoleById(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select authority from role where id=?""",id)
		return rows
	}
}
