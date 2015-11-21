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
	
    def getWorksheetsByUserId(id) {
		def sql = new Sql(dataSource)
		def rows = sql.rows("""select name, id from worksheet where owner=?""",id)
		return rows
    }
	
	def addRubricIdToWorksheet(int w_id, int r_id){
		def sql=new Sql(dataSource)
		sql.execute("""update worksheet set r_id=? where id=?""",r_id,w_id)
	}
	
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
	
	@Transactional
	def addResults(Map results,int id){
		def instance = Worksheet.get(id)
		instance.wsResults = new JsonBuilder(results).toString()
		instance.save()
	}
	
	def getRubricId(id){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select r_id from worksheet where id=?""",id)
		return rows[0]['R_ID']
	}
	
	def getWorksheetIds(){
		def sql=new Sql(dataSource)
		def rows=sql.rows("""select id from worksheet""")
		return rows
	}
}
