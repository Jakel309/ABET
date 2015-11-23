package com.ABET

//This is the schema for a rubric that is attached to every worksheet
class Rubrics {
	
	String name
	int numQues

    static constraints = {
		name blank:false, unique:true
    }
}
