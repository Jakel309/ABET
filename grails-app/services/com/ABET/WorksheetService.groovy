package com.ABET

import grails.transaction.Transactional
import org.springframework.transaction.annotation.Transactional
import groovy.sql.Sql
import com.ABET.Worksheet

import java.sql.Clob
import java.util.Map;

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

@Transactional
class WorksheetService {

	def dataSource
	
	//Returns the name and id of all worksheets that are assigned to a specified user given their id
    def getWorksheetsByUserId(id) {
		def sql = new Sql(dataSource)
		def rows = sql.rows("""select name, id from worksheet where owner=?""",id)
		return rows
    }
	
	//Adds a rubric id to a worksheet given the worksheet id and the rubric id
	def addRubricIdToWorksheet(int w_id, int r_id){
		def sql=new Sql(dataSource)
		sql.execute("""update worksheet set r_id=? where id=?""",r_id,w_id)
	}
	
	//Returns the answers to general worksheet questions and converts them to a map
	def getWorksheetAnswers(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select ws_results from worksheet where id=?""",id)
		java.sql.Clob clob = (java.sql.Clob) rows[0]['WS_RESULTS']
		Map map=[:]
		if(clob){
			String valueFromClob = clob.getSubString(1, clob.length().intValue())
			map=new JsonSlurper().parseText(valueFromClob)
		}
		return map
	}
	
	//Adds the results of the general questions to the worksheet row
	@Transactional
	def addResults(Map results,int id){
		def instance = Worksheet.get(id)
		instance.wsResults = new JsonBuilder(results).toString()
		instance.save()
	}
	
	//Returns the rubric id of worksheet given the worksheet id
	def getRubricId(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select r_id from worksheet where id=?""",id)
		return rows[0]['R_ID']
	}
	
	//Returns all ids of worksheets
	def getWorksheetIds(){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id from worksheet""")
		return rows
	}
}
