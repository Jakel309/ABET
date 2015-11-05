package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class FormService {
	def dataSource

    def addForm(String name, int numComp) {
		def sql=new Sql(dataSource)
		sql.execute("""insert into form (name,num_ques) values (?,?)""",name,numComp)
    }
	
	def getFormIdByName(String name){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id from form where name=?""",name)[0][0]
		return rows
	}
	
	def createQuestion(String question, String formName){
		def sql=new Sql(dataSource)
		sql.execute("""insert into questions(question) values (?)""",question)
		sql.execute("""insert into from_questions (f_id, q_id) values ((select id from form where name=?),(select id from question where question=?))""",formName,question)
	}
}
