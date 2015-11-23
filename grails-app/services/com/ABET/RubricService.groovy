package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql
import java.sql.Clob
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

@Transactional
class RubricService {
	def dataSource

	//Adds rubric data to database given the name and the number of questions
    def addRubric(String name, int numComp) {
		def sql=new Sql(dataSource)
		sql.execute("""insert into rubrics (version,name,num_ques) values (1,?,?)""",name,numComp)
    }
	
	//Gets the id for a rubric given the name of the rubric
	def getRubricIdByName(String name){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id from rubrics where name=?""",name)[0][0]
		return rows
	}
	
	//Creates a rubric question and added to the database
	def createQuestion(String question, int id){
		def sql=new Sql(dataSource)
		sql.execute("""insert into questions(version, question, r_id) values (1,?,?)""",question,id)
	}
	
	//Gets all rubrics from the database
	def getRubrics(){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id, name from rubrics""")
		return rows
	}
	
	//Gets all the questions for a rubric given the rubric's id
	def getRubricQuestions(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select question from questions where r_id=?""",id)
		return rows
	}
	
	//Returns all information of a rubric given its id
	def getRubricById(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select * from rubrics where id=?""",id)
		return rows
	}
	
	//Adds the rubric results to the worksheet table given the results and the id of the worksheet
	def addResults(Map results,id, w_id){
		def sql=new Sql(dataSource)
		sql.execute("""update worksheet set r_results=? where id=?""",new JsonBuilder(results).toString(),w_id)
	}
	
	//Returns the rubric results from the database and converts them into a map
	def getResults(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select r_results from worksheet where id=?""",id)
		Map map=[:]
		if(rows){
			java.sql.Clob clob = (java.sql.Clob) rows[0]['R_RESULTS']
			if(clob){
				String valueFromClob = clob.getSubString(1, clob.length().intValue())
				map=new JsonSlurper().parseText(valueFromClob)
			}
		}
		return map
	}
}
