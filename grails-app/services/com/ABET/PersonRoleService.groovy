package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class PersonRoleService {

	def dataSource
	
    def getPRByPID(id) {
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select * """)
    }
}
