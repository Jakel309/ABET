package com.ABET

class RubricController {

	def rubricService
	def worksheetService
	def worksheetQuestionsService
	def springSecurityService
	
	//Renders the index page
    def index() { }
	
	//Renders the createRubric page with the worksheet id sent to it
	def newRubric(String w_id){
		render(view:"createRubric", model:[w_id:w_id])
	}
	
	//Creates the rubric and adds it to the database then renders the create questions page with the number of 
	//rubric questions specified on the createRubric page
	def createRubric(String name, int numComp, String w_id){
		rubricService.addRubric(name,numComp)
		def id=rubricService.getRubricIdByName(name)
		render(view:"createQuestions", model:[numComp:numComp, id:id, w_id:w_id])
	}
	
	//Shows the select rubric page and sends all created rubrics to the page
	def selectRubric(w_id){
		def rows = rubricService.getRubrics()
		render (view:'selectRubric', model:[rows:rows,w_id:w_id])
	}
	
	//Renders the page that contains the worksheet questions and the rubric questions that was either selected or created
	def chooseRubric(int r_id, int w_id){
		worksheetService.addRubricIdToWorksheet(w_id, r_id)
		def r_rows=rubricService.getRubricQuestions(r_id)
		def w_rows=worksheetQuestionsService.getWorksheetQuestions()
		def ws_results=worksheetService.getWorksheetAnswers(w_id)
		def r_results=rubricService.getResults(r_id)
		render (view:'worksheetCompletion', model:[questions:r_rows, r_id:r_id, w_id:w_id, w_questions:w_rows, ws_results:ws_results, r_results:r_results])
	}
	
	//Creates questions for a created rubric
	def addQuestions={
		println params.numComp
		for(i in 1..params.numComp.toInteger()){
			if (params["question${i}"]!=null){
				rubricService.createQuestion(params["question${i}"], params.id.toInteger())
			}
		}
		chooseRubric(params.id.toInteger(),params.w_id.toInteger())
	}
	
	//Submits the answers provided by the user and adds them to the database
	def rubricSubmit={
		def wsCount=worksheetQuestionsService.getWorksheetQuestionCount()
		def ws_results=[:]
		for(i in 1..wsCount){
			ws_results.put(params["ws_question${i}"],params["ws_question${i}-A"])
		}
		worksheetService.addResults(ws_results,params.w_id.toInteger())
		
		def numCount=rubricService.getRubricById(params.r_id.toInteger())[0]["num_ques"]
		def results=[:]
		for(i in 1..numCount){
			println params["${i}-1"]
			def temp=[:]
			temp.put("Unacceptable", params["${i}-1"])
			temp.put("Marginal", params["${i}-2"])
			temp.put("Expected", params["${i}-3"])
			temp.put("Outstanding", params["${i}-4"])
			results.put(params["question${i}"], temp)
		}
		results.put("Comments",params['comments'])
		rubricService.addResults(results,params.r_id.toInteger(),params.w_id.toInteger())
		render(view:'index')
	}
	
	//Returns all worksheets that belong to the currently logged in user
	def getWorksheets(){
		def id=springSecurityService.principal.getId()
		def rows=worksheetService.getWorksheetsByUserId(id)
		return rows
	}
	
	//Used to display the questions in the worksheet to the user if the user already added a rubric to the worksheet,
	//or sends the user to rubric selection page to either select or create another page
	def renderWorksheet(String w_id){
		def r_id=worksheetService.getRubricId(w_id)
		if(!r_id){
			selectRubric(w_id)
		}else{
			Map ws_results=worksheetService.getWorksheetAnswers(w_id)
			def r_rows=rubricService.getRubricQuestions(r_id)
			def w_rows=worksheetQuestionsService.getWorksheetQuestions()
			Map r_results=rubricService.getResults(w_id)
			println r_results
			render (view:'worksheetCompletion', model:[questions:r_rows, r_id:r_id, w_id:w_id, w_questions:w_rows, ws_results:ws_results, r_results:r_results])
		}
	}
}
