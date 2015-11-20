package com.ABET

class WorksheetQuestions {
	
	int id
	String question
	boolean isActive

    static constraints = {
		id blank:false, unique:true
		question blank:false
    }
}
