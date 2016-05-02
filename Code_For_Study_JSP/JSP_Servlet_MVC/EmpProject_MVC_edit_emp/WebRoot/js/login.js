function validateAid() {
	return validateEmpty("aid") ;
}
function validatePassword() {
	return validateEmpty("password") ;
}
function validateCode() {
	return validateRegex("code",/[a-zA-Z0-9]{4}/) ;
}
function validateConf() {
	return validateCompare("password","conf") ; 
}
function validateCompare(srcId,desId) { 
	var srcObj = document.getElementById(srcId) ;
	var desObj = document.getElementById(desId) ;
	var span = document.getElementById(desId + "Msg") ;
	if (srcObj.value == desObj.value) {	// 内容相同	
		desObj.className = "success" ; 
		span.className = "right" ;
		return true ;
	} else {
		desObj.className = "fail" ;
		span.className = "wrong" ;
		return false ; 
	}
}
function validate() {
	return	validateAid() && validatePassword() && validateCode();
}
function validateInsert() { 
	return	validateAid() && validatePassword() && validateConf();
}