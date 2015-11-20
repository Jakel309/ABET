package com.ABET

import grails.transaction.Transactional
import groovy.sql.Sql
import java.sql.Clob
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

@Transactional
class RubricService {
	def dataSource

    def addRubric(String name, int numComp) {
		def sql=new Sql(dataSource)
		sql.execute("""insert into rubrics (version,name,num_ques) values (1,?,?)""",name,numComp)
    }
	
	def getRubricIdByName(String name){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id from rubrics where name=?""",name)[0][0]
		return rows
	}
	
	def createQuestion(String question, int id){
		def sql=new Sql(dataSource)
		sql.execute("""insert into questions(version, question, r_id) values (1,?,?)""",question,id)
	}
	
	def getRubrics(){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id, name from rubrics""")
		return rows
	}
	
	def getRubricQuestions(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select question from questions where r_id=?""",id)
		return rows
	}
	
	def getRubricById(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select * from rubrics where id=?""",id)
		return rows
	}
	
	def addResults(Map results,id, w_id){
		def sql=new Sql(dataSource)
		def resultId=sql.rows("""select id from results where worksheet_id=?""",w_id)[0]['ID']
		if(resultId){
			sql.execute("""update results set results=? where worksheet_id=?""",new JsonBuilder(results).toString(),w_id)
		}else{
			sql.execute("""insert into results (version,results,r_id,WORKSHEET_ID) values (1,?,?,?)""",new JsonBuilder(results).toString(), id,w_id)
		}
	}
	
	//This is for proof of concept to convert from clob to map. It's painful
	def getResults(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select results from results where r_id=?""",id)
		Map map=[:]
		if(rows){
			java.sql.Clob clob = (java.sql.Clob) rows[0]['RESULTS']
			if(clob){
				String valueFromClob = clob.getSubString(1, clob.length().intValue())
				map=new JsonSlurper().parseText(valueFromClob)
			}
		}
		return map
	}
}
