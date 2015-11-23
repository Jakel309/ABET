package com.ABET

//This is the schema for the questions for a rubric
class Questions {
	
	String question
	int r_id

    static constraints = {
		question blank:false
		r_id blank:false
    }
}
