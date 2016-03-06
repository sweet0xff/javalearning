window.onload=function(){
	var para = document.createElement("p");
	var txt =document.createTextNode("Hello,world!")
	para.appendChild(txt);
	var testdiv = document.getElementById("testdiv");
	testdiv.appendChild(para);
	var para_2 = document.createElement("pl");
	var txt_2 = document.createTextNode("This is")
	para_2.appendChild(txt_2);
	var testdiv = document.getElementById("testdiv");
	testdiv.appendChild(para_2);
	var emphasis = document.createElement("em");
	var txt_3 = document.createTextNode(" a");
	emphasis.appendChild(txt_3);
	para_2.appendChild(emphasis);
	var txt_4 = document.createTextNode(" test.");
	para_2.appendChild(txt_4);
	testdiv.appendChild(para_2);	
}
