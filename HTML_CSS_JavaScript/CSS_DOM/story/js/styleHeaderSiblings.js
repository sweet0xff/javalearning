function styleHeaderSiblings() {
	if(!document.getElementsByTagName) return false;
	var headers = document.getElementsByTagName("h1");
	var elem;
	for ( var i =0; i <headers.length; i++) {
		elem = getNextElement(headers[i].nextSiblings);
		elem.style.fontWeight = "bold";
		elem.style.fontSize = "2em";
	}
	
	function getNextElement(node) {
		if(node.nodeType == 1) {
			return node;
		}
		if (node.nextSibling) {
			return getNextElemet(node.nextSibling);	
		}
		return null;
	}
}
addLoadEvent(styleHeaderSiblings)
