console.log("hsghrklov");

function generateShortUrl(){

    let targetUrl = document.querySelector('#targeturl');
    let resultField = document.querySelector('.result');
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/";

    xhr.open("POST", url);
    xhr.setRequestHeader("Content-Type", "application/json")

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          resultField.innerHTML = this.responseText;
        }
      };

    var data = JSON.stringify({"targetUrl": targetUrl.value});
    xhr.send(data);
}

const shortButton = document.querySelector('#button');
shortButton.addEventListener("click", generateShortUrl)




