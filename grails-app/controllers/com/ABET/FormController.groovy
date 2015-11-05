package com.ABET

import com.ABET.FormService

class FormController {

	def formService
	
    def index() { }
	
	def newForm(){
		render(view:"createForm")
	}
	
	def createForm(String name, int numComp){
		formService.addForm(name,numComp)
		def id=formService.getFormIdByName(name)
		render(view:"createQuestions", model:[numComp:numComp, name:name])
	}
	
	def addQuestions={
		for(i in 1..params.numComp){
			if (params["questions${i}"]!=null)
				formService.createQuestion(params["question${i}"], params.name)
		}
		render(view:"index")
	}
}
