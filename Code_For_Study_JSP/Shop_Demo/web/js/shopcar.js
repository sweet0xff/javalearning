var allPrice = 0.0;
window.onload = function () {
    document.getElementById("result").innerHTML = "<font color='red'>总金额:" + allPrice + "<font>";
}
function calGoods(gid) {
    var price = parseFloat(document.getElementById("price-" + gid).innerHTML);  // 价格
    var count = parseInt(document.getElementById(gid).value); // 数量
    allPrice += (price * count);
    document.getElementById("cal-" + gid).innerHTML = "<font color='red'>" + (price * count) + "<font>";
    if (document.getElementById("result") != undefined) {
        document.getElementById("result").innerHTML = "<font color='red'>总金额:" + allPrice + "<font>";
    }
}
function addBut(gid) {
    var price = parseFloat(document.getElementById("price-" + gid).innerHTML);  // 价格
    var count = parseInt(document.getElementById(gid).value); // 数量
    allPrice -= (price * count);
    count++;
    document.getElementById(gid).value = count;
    calGoods(gid);
}
function subBut(gid) {
    var price = parseFloat(document.getElementById("price-" + gid).innerHTML);  // 价格
    var count = parseInt(document.getElementById(gid).value); // 数量
    allPrice -= (price * count);
    if (count == 0) {
        count--;
        document.getElementById(gid).value = count;
        calGoods(gid);
    }
}
