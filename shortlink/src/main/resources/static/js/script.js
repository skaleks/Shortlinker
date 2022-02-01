const input = document.getElementById("input");
const button = document.getElementById("button");
const history = document.getElementById("history");
const message = document.getElementById("message");

const URL_REG = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w\.-]*)*\/?$/;
const url = "http://localhost:8080/";

function addItemToHistory(userLink, shortLink) {
  const historyItem = document.createElement("li");
  historyItem.classList.add("history__item");
  const userLinkCut =
    userLink.length > 40 ? userLink.substr(0, 40) + "..." : userLink;

  historyItem.innerHTML = `
     <a href="${userLink}" target="_blank">${userLinkCut}</a>
     <span> ======> </span>
     <span class="new_link" onclick="copyShortLinkToBuffer(this.innerText); showCopyMessage();">${shortLink}</span>
     `;
  history.appendChild(historyItem);
}

function copyShortLinkToBuffer(link) {
  navigator.clipboard.writeText(link);
}

function showCopyMessage() {
  message.innerText = "Link is copied to the buffer!";

  setTimeout(() => (message.innerText = " "), 1500);
}

function clearInput() {
  input.value = "";
  button.disabled = true;
}

function disableBtn() {
  message.innerText = "";

  if (input.value == "") {
    button.disabled = true;
  } else {
    button.disabled = false;
  }
}

function sendUrl() {
  const userLink = input.value;
  let shortLink;

  if (userLink.match(URL_REG)) {

    const xhr = new XMLHttpRequest();

    xhr.open("POST", url);
    xhr.setRequestHeader("Content-Type", "application/json")
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        shortLink = this.responseText;
        addItemToHistory(userLink, shortLink);
        copyShortLinkToBuffer(shortLink);
        showCopyMessage();
        clearInput();
      }
    };
  const data = JSON.stringify({"userLink": userLink});
  xhr.send(data);
  } else {
    message.innerText = "Print the link!";
  }
}

button.addEventListener("click", sendUrl);
input.addEventListener("change", disableBtn);
document.addEventListener("keypress", disableBtn);
