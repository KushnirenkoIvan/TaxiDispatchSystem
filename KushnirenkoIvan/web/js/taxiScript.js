/**
 * Created by ivan on 18.08.15.
 */
function sendDriverData() {

    var xhr = new XMLHttpRequest();

    var d_id = document.getElementById('d_id').value;
    var d_name = document.getElementById('d_name').value;
    var d_phone = document.getElementById('d_phone').value;
    var d_c_number = document.getElementById('d_c_number').value;
    var d_c_model = document.getElementById('d_c_model').value;

    alert(d_id);

    //if (d_id === undefined) {
    //    alert('Filed id cannot be empty.');
    //    return;
    //}
    //
    //if (d_name === undefined) {
    //    alert('Filed name cannot be empty.');
    //    return;
    //}
    //
    //if (d_phone === undefined) {
    //    alert('Filed phone cannot be empty.');
    //    return;
    //}
    //
    //if (d_c_number === undefined) {
    //    alert('Filed car number cannot be empty.');
    //    return;
    //}
    //
    //xhr.open('POST', '/addDriver?id=' + d_id + '&&name=' + d_name + '&phone=' + d_phone + '&number=' + d_c_number + '&c_model=' + d_c_model, true);
    //console.log('POST', '/addDriver?id=' + d_id + '&&name=' + d_name + '&phone=' + d_phone + '&c_number=' + d_c_number + '&c_model=' + d_c_model, true);
    //xhr.send();
    //
    //xhr.onreadystatechange = function () {
    //    alert("Success!");
    //}
}

function logout() {
    var xhr = new XMLHttpRequest();

    xhr.open("GET", '/logout', true);
    console.log("GET", '/logout', true);
    xhr.send();
}
function onload() {
    window.onload
}
var ajax = new XMLHttpRequest();
ajax.onreadystatechange = function () {
    if (ajax.readyState == 4 && ajax.status == 200) {
        var name = document.getElementById("send");
        name.innerHTML = ajax.responseText;
        alert(ajax.responseText);
    }
};

function openDriverForm() {
    window.open('/driverAddForm', 'newWin', 'Toolbar=0, Location=0, Directories=0, Status=0, Menubar=0,' +
        ' Scrollbars=0, Resizable=0, Copyhistory=1, Width=300, Height=270');
}

function openClientForm() {
    window.open('/clientAddForm', 'newWin', 'Toolbar=0, Location=0, Directories=0, Status=0, Menubar=0,' +
        ' Scrollbars=0, Resizable=0, Copyhistory=1, Width=300, Height=230');
}

function openOrderForm() {
    window.open('/orderAddForm', 'newWin', 'Toolbar=0, Location=0, Directories=0, Status=0, Menubar=0,' +
        ' Scrollbars=0, Resizable=0, Copyhistory=1, Width=300, Height=300');
}

function digitalWatch() {
    var tm = new Date();

    var dd = tm.getDay();
    var mm = tm.getMonth();
    var yy = tm.getYear();

    var h = tm.getHours();
    var m = tm.getMinutes();
    var s = tm.getSeconds();

    if (h < 10) {
        h = "0" + h;
    }
    if (m < 10) {
        m = "0" + m;
    }
    if (s < 10) {
        s = "0" + s;
    }

    document.getElementById('digital_watch').innerHTML = h + ":" + m + ":" + s;

    setTimeout("digitalWatch()", 1000);

}

function createText() {
    var childDiv = document.createElement('div');
    var textNode = document.createTextNode('This is a text node in div.');
    childDiv.appendChild(textNode);
    var parent = document.getElementById('td');
    childDiv.className = 'ajaxDiv';
    parent.appendChild(childDiv);
    alert("Its cool!");

}
