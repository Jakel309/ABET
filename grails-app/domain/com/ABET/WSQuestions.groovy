package com.ABET

class WSQuestions {
	
	int id
	String question
	boolean isActive

    static constraints = {
		id blank:false, unique:true
		question blank:false
    }
}
