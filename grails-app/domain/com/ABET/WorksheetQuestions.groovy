package com.ABET

//This is the schema for the general questions for each worksheet
class WorksheetQuestions {
	
	int id
	String question
	boolean isActive

    static constraints = {
		id blank:false, unique:true
		question blank:false
    }
}
