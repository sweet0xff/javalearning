function changeColor(obj,color){
	obj.bgColor = color ;
}
function validateEmpty(id) {
	var obj = document.getElementById(id) ;
	var span = document.getElementById(id + "Msg") ;
	if (obj.value.length != 0) {	
		obj.className = "success" ;
		span.className = "right" ;
		return true ;
	} else {
		obj.className = "fail" ;
		span.className = "wrong" ;
		return false ;
	}
}
function validateRegex(id,regex) {
	var obj = document.getElementById(id) ;
	var span = document.getElementById(id + "Msg") ;
	if (regex.test(obj.value)) {	
		obj.className = "success" ;
		span.className = "right" ;
		return true ;
	} else {
		obj.className = "fail" ;
		span.className = "wrong" ;
		return false ;
	}
}

// 第一个参数是控制全选的复选框名称，第二个参数是实现全选功能的组件名称
function selectAll(controlElement,selectElement) {
	var instObj = document.all(selectElement) ;
	if(instObj.length == undefined) {	// 不是数组
		instObj.checked = document.getElementById(controlElement).checked ;
	} else {
		for (var x = 0 ; x < instObj.length ; x ++) {
			instObj[x].checked = document.getElementById(controlElement).checked ;
		} 
	}
}
// 删除单条数据前的确认
function deleteConfirm() {
	return window.confirm("确定要删除此数据吗？") ;
}
// 进行数据删除批量删除，不使用表单提交
function deleteBatchHandle(ele,url) {
	var count = 0 ;	// 保存元素的选中个数
	var obj = document.all(ele) ;	// 取得全部的元素
	if(obj.length == undefined) {	// 不是数组
		if (obj.checked) {	// 有选中
			count ++ ;
		}
	} else {	// 是数组
		for (var x = 0 ; x < obj.length ; x ++) {
			if (obj[x].checked) {
				count ++ ;
			}
		}
	}
	if (count == 0) {	// 没有任何的数据被选中过
		alert("您还未选择要删除的数据！") ;
		return false ;
	}
	if (confirm("确定要删除此数据吗？")) {	// 表示确定删除
		url += "?" ;	// 地址和参数的分割符
		for (var x = 0 ; x < obj.length ; x ++) {
			if (obj[x].checked) {
				url += "deptno=" + obj[x].value + "&" ;
			}
		}
		window.location = url ;
	}
}
// 删除多条数据前的确认
function deleteBatchConfirm(ele) {
	var count = 0 ;	// 保存元素的选中个数
	var obj = document.all(ele) ;	// 取得全部的元素
	if(obj.length == undefined) {	// 不是数组
		if (obj.checked) {	// 有选中
			count ++ ;
		}
	} else {	// 是数组
		for (var x = 0 ; x < obj.length ; x ++) {
			if (obj[x].checked) {
				count ++ ;
			}
		}
	}
	if (count == 0) {	// 没有任何的数据被选中过
		alert("您还未选择要删除的数据！") ;
		return false ;
	}
	return deleteConfirm() ;	// 调用其它函数
}
// 定义一个函数，此函数提供了弹出窗口的控制
function openWindow(thisurl, title, w, h) {
	window.open(thisurl, title, "width=" + w + ",height=" + h
			+ ",scrollbars=no,resizable=yes");
}