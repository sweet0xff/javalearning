function validateDeptno(num) {
	if (validateDeptno.arguments.length == 0) { // 没有参数，由dept_insert.jsp调用
		return validateRegex("deptno", /^\d{2}$/);
	} else { // 有参数，由dept_list.jsp调用
		return validateRegex("deptno-" + num, /^\d{2}$/);
	}
}
function validateDname(num) {
	if (validateDname.arguments.length == 0) {
		return validateEmpty("dname");
	} else {
		return validateEmpty("dname-" + num);
	}
}
function validateLoc(num) {
	if (validateLoc.arguments.length == 0) {
		return validateEmpty("loc");
	} else {
		return validateEmpty("loc-" + num);
	}
} 
function validate(num) {
	if (validate.arguments.length == 0) {
		return validateDeptno() && validateDname() && validateLoc();
	} else {
		return validateDeptno(num) && validateDname(num) && validateLoc(num);
	}
}