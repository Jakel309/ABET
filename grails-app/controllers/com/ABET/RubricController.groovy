package com.ABET

class RubricController {

	def rubricService
	def worksheetService
	def springSecurityService
	
    def index() { }
	
	def newRubric(){
		render(view:"createRubric")
	}
	
	def createRubric(String name, int numComp){
		rubricService.addRubric(name,numComp)
		def id=rubricService.getRubricIdByName(name)
		render(view:"createQuestions", model:[numComp:numComp, id:id])
	}
	
	def addQuestions={
		for(i in 1..params.numComp.toInteger()){
			if (params["question${i}"]!=null){
				rubricService.createQuestion(params["question${i}"], params.id.toInteger())
			}
		}
		render(view:"index")
	}
	
	def selectRubric(){
		def rows = rubricService.getRubrics()
		render (view:'selectRubric', model:[rows:rows])
	}
	
	def chooseRubric(int id){
		def rows=rubricService.getRubricQuestions(id)
		render (view:'rubricCompletion', model:[questions:rows, id:id])
	}
	
	def rubricSubmit={
		println params
		def numCount=rubricService.getRubricById(params.id.toInteger())[0]["num_ques"]
		def results=[:]
		for(i in 1..numCount){
			results.put(params["question${i}"], ["Unacceptable":params["${i}-1"],"Marginal":params["${i}-2"],"Expected":params["${i}-3"],"Outstanding":params["${i}-4"]])
		}
		println results
		rubricService.addResults(results,params.id.toInteger())
		render(view:'index')
	}
	
	def getWorksheets(){
		def id=springSecurityService.principal.getId()
		def rows=worksheetService.getWorksheetsByUserId(id)
		return rows
	}
	
	def renderWorksheet(id){
		println id
		render(view:'index')
	}
}
