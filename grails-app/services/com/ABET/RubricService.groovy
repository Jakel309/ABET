package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class RubricService {
	def dataSource

    def addRubric(String name, int numComp) {
		def sql=new Sql(dataSource)
		sql.execute("""insert into rubric (name,num_ques) values (?,?)""",name,numComp)
    }
	
	def getRubricIdByName(String name){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id from rubric where name=?""",name)[0][0]
		return rows
	}
	
	def createQuestion(String question, String name){
		def sql=new Sql(dataSource)
		sql.execute("""insert into questions(question) values (?)""",question)
		sql.execute("""insert into rubric_questions (r_id, q_id) values ((select id from rubric where name=?),(select id from question where question=?))""",name,question)
	}
}
