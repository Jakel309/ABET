package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class ProgramService {

	def dataSource
	
	//Returns a list of all programs with id and name
    def getPrograms() {
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select * from program""")
		return rows
    }
}
