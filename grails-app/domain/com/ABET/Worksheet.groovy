package com.ABET

//This is the schema for the worksheet table
class Worksheet {
	
	String name
	String wsResults
	static belongsTo=[program:Program]
	int owner
	int r_id
	String rResults

    static constraints = {
		name blank:false
		owner blank:false
		wsResults nullable:true
		r_id nullable:true
		rResults nullable:true
    }
	
	static mapping={
		wsResults type:'text'
		rResults type:'text'
	}
}
