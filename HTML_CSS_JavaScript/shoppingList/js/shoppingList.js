window.onload = function() {
	if (!document.getElementsByClassName) {
		document.getElementsByClassName= function(cls) {
		var ret= [];
		var els = document.getElementsByTagName("*");
		for (var i = 0; i < els.length;i++){
			if(els[i].className ===cls 
			||els[i].className.indexOf(cls + " ") >= 0
			||els[i].className.indexOf(" " + cls + " ") >=0
			||els[i].className.indexOf(" " + cls) >= 0) {
				ret.push(els[i]);
			}
		}
			
		}
	}
	var cartTable = document.getElementById("cartTable");
	var tr = cartTable.children[1].rows;
	var checkInputs = document.getElementsByClassName("check");
	var checkAllInputs = document.getElementsByClassName("check-all");
	var selectTotal = document.getElementById("selectedTotal");
	var priceTotal = document.getElementById("priceTotal");
	var selected = document.getElementById("selected");	
	var foot = document.getElementById("foot");
	var deleteAll = document.getElementById("deleteAll");


	//计算价格
	function getTotal() {
		var selected = 0 ;
		var price = 0;
		for(var i = 0 ; i < tr.length; i ++ ) {
			if (tr[i].getElementsByTagName("input")[0].checked){
				tr[i].className = "on";
				selected += parseInt(tr[i].getElementsByTagName("input")[1].value);
				price +=parseFloat(tr[i].cells[4].innerHTML); 
			} else{
				tr[i].className = "";
			}
		}
		selectTotal.innerHTML = selected;
		priceTotal.innerHTML = price.toFixed(2);
	}
	
	//小计价格
	function getSubTotal(tr) {
		var tds = tr.cells;	
		var price = parseFloat(tds[2].innerHTML);
		var count = parseInt(tr.getElementsByTagName("input")[1].value);
		var SubTotal = parseFloat(price*count);
		tds[4].innerHTML = SubTotal.toFixed(2);
	}

	for( var i = 0; i < checkInputs.length; i++){
		checkInputs[i].onclick = function () {
			if(this.className==="check-all check") {
				for(var j = 0 ; j < checkInputs.length;j ++) {
					checkInputs[j].checked = this.checked;
				}
			}else if (this.check == false) {
				for(var k = 0 ; k < checkInputs.length; k++) {
					checkAllInputs.checked = false;
				}
			}
			getTotal();
		}
	}
	
//	selected.onclick = function() {
//		if(foot.className = "foot show")  {
//			foot.className  = "foot show"
//		}else {
//			foot.className = "foot";
//		}
//	}
	for(var i = 0; i < tr.length;i ++) {
		tr[i].onclick= function(e) {
			e = e ||window.event;
			var el = e.srcElement;
			var cls = el.className;
			var input = this.getElementsByTagName("input")[1];
			var val = parseInt(input.value);
			var reduce = this.getElementsByTagName("span")[1];
			switch(cls) {
				case "add":
					input.value = val +1;
					reduce.innerHTML = "-";
					getSubTotal(this);
				break;

				case "reduce":
					if (val >1) {
						input.value = val - 1
					}
					if (val <= 1) {
						reduce.innerHTML = "";	
					}
				getSubTotal(this);
				break;
				
				case "delete":
					if(this.getElementsByTagName("input")[0].checked){
						var conf = confirm("Are you sure?");
						if(conf) {
							this.parentNode.removeChild(this);
						}
					}
					break;
				default:
				    break;
			}
			getTotal();
		}
		tr[i].getElementsByTagName("input")[1].onkeyup = function (){
			var val = parseInt(this.value);
			var tr = this.parentNode.parentNode;
			var reduce = tr.getElementsByTagName("span")[1];
			if (isNaN(val) || val < 1) {
				val = 1 ;
			}
			this.value = val;
			if ( reduce <=1) {
				reduce.innerHTML = "";
			}else {
				reduce.innerHTML = "-";
			}
			getSubTotal(tr);	
			getTotal();
		}
	}
		
	deleteAll.onclick = function() {
		if(selectTotal.innerHTML !=0) {
			var conf = confirm("Are you sure?")
			if (conf) {
				for( var i = 0; i < tr.length; i ++) {
					var input = tr[i].getElementsByTagName("input")[0];
						if(input.checked){
							tr[i].parentNode.removeChild(tr[i]);
							i--;
						}
				}
			}
		}
	}
}
