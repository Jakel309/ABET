package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class WorksheetService {

	def dataSource
	
    def getWorksheetsByUserId(id) {
		def sql = new Sql(dataSource)
		def rows = sql.rows("""select name, id from worksheet where owner=?""",id)
		println rows
		return rows
    }
}
