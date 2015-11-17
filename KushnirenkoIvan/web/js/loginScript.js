/**
 * Created by ivan on 18.08.15.
 */
function sendData() {

    var xhr = new XMLHttpRequest();
    var login = document.getElementById('login').value;
    var password = document.getElementById('pass').value;

    xhr.open('POST', '/submit?login=' + login + '&&password=' + password, true);
    console.log('POST', '/submit?login=' + login + '&&password=' + password, true);
    xhr.send();

}