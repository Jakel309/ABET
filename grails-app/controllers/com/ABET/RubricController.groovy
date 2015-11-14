package com.ABET

class RubricController {

	def rubricService
	
    def index() { }
	
	def newRubric(){
		render(view:"createRubric")
	}
	
	def createRubric(String name, int numComp){
		rubricService.addRubric(name,numComp)
		def id=rubricService.getRubricIdByName(name)
		render(view:"createQuestions", model:[numComp:numComp, name:name])
	}
	
	def addQuestions={
		for(i in 1..params.numComp){
			if (params["questions${i}"]!=null)
				rubricService.createQuestion(params["question${i}"], params.name)
		}
		render(view:"index")
	}
}
