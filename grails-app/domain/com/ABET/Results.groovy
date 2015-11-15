package com.ABET

class Results {
	
	int r_id
	String results
	Worksheet worksheet

    static constraints = {
		r_id blank:false
		results blank:false
    }
	
	static mapping={
		r_id type:'text'
	}
}
