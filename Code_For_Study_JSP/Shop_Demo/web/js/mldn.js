function validateEmpty(element) { //判断是否为空
    var objElement = document.getElementById(element);// 取得id元素对象
    var msgElement = document.getElementById(element + "Msg"); // 取得span中id元素对象

    if (objElement.value != "") {
        objElement.className = "right";
        msgElement.innerHTML = "<font color='green'><strong>内容输入正确!</strong></font>"
        return true;
    } else {
        objElement.className = "wrong";
        msgElement.innerHTML = "<font color='#ff0000'><strong>内容输入不正确!</strong></font>"
        return false;
    }
}

function validateRegex(element, Regex) { //判断是否为空
    var objElement = document.getElementById(element);// 取得id元素对象
    var msgElement = document.getElementById(element + "Msg"); // 取得span中id元素对象

    if (Regex.test(objElement.value)) {
        objElement.className = "right";
        msgElement.innerHTML = "<font color='green'><strong>内容输入正确!</strong></font>"
        return true;
    } else {
        objElement.className = "wrong";
        msgElement.innerHTML = "<font color='#ff0000'><strong>内容输入不正确!</strong></font>"
        return false;
    }
}

function changeColor(obj, color) { // 改变表单颜色
    obj.bgColor = color;
}
// 实现全选功能
function checkboxSelect(obj, eleName) {
    var item = document.all(eleName);
    if (item.length == undefined) {
        document.getElementById(eleName).checked = this.checked;
    } else {
        for (var x = 0; x < item.length; x++) {
            item[x].checked = obj.checked;
        }
    }
}
function updateAll(url, paramName, eleName) {
    deleteAll(url, paramName, eleName);
}
// 实现批量删除
function deleteAll(url, paramName, eleName) {
    var data = ""; // 保存所有要删除的数据编号
    // 但是有可能是数组，也有可能是一个
    var item = document.all(eleName);
    var count = 0;// 保持要删除的个数
    // 判断是否有要删除的数据
    if (item.length == undefined) { // 表示只有一个元素，不是数组
        if (document.getElementById(eleName).checked == true) {
            data += document.getElementById(eleName).value + "|";
            count++;
        }
    } else {
        for (var x = 0; x < item.length; x++) {
            if (item[x].checked == true) {
                count++;
                data += item[x].value + "|";
            }
        }
    }
    if (count > 0) { // 表示有要删除的数据
        if (window.confirm("确定要执行操作吗？")) {
            window.location = url + "&" + paramName + "=" + data;
        }
    } else {
        alert("你还没有选择要执行操作的数据!");
    }
}

function goList(url, iid) {
    window.location = url + "?iid=" + iid;
}