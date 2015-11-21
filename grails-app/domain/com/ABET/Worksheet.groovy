package com.ABET

class Worksheet {
	
	String name
	String wsResults
	static hasOne=[results:Results]
	static belongsTo=[program:Program]
	int owner
	int r_id
	String rResults

    static constraints = {
		name blank:false
		owner blank:false
		wsResults nullable:true
		results nullable:true
		r_id nullable:true
		rResults nullable:true
    }
	
	static mapping={
		wsResults type:'text'
		rResults type:'text'
	}
}
