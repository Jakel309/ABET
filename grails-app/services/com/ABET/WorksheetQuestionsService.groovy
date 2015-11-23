package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class WorksheetQuestionsService {
	
	def dataSource

	//Returns all currently active worksheet question
    def getWorksheetQuestions(){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select question from worksheet_questions where is_Active=TRUE""")
		return rows
	}
	
	//Returns the number of currently active worksheet questions
	def getWorksheetQuestionCount(){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select count(*) as count from worksheet_questions where is_active=TRUE""")
		return rows[0]['COUNT']
	}
}
