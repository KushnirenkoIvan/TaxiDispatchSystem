/**
 * Created by ivan on 01.09.15.
 */

function showOrders() {

    // 1. Создаём новый объект XMLHttpRequest
    var xhr = new XMLHttpRequest();

    // 2. Конфигурируем его: GET-запрос на URL 'phones.json'
    xhr.open('GET', 'getOrders', true);

    // 3. Отсылаем запрос
    xhr.send();

    // 4. Если код ответа сервера не 200, то это ошибка
    xhr.onreadystatechange = function () {
        if (xhr.status != 200) {
            // обработать ошибку
            alert('error: ' + xhr.status + ': ' + xhr.statusText); // пример вывода: 404: Not Found
        } else {
            // вывести результат
            alert('status - ' + xhr.status + ': ' + xhr.statusText); // responseText -- текст ответа.
            var order = document.getElementById('td');
            order.innerHTML = xhr.responseText;
        }
    }
}