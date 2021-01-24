var xmlHttpRequest;
function createXMLHttpRequest()
{
    if (window.XMLHttpRequest) //非IE浏览器
    {
        xmlHttpRequest = new XMLHttpRequest();
    }
    else if (window.ActiveObject)//IE6以上版本的IE浏览器
    {
        xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
    }
    else //IE6及以下版本IE浏览器
    {
        xmlHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
    }
}

function completeItemList() {
    var keyword = document.getElementById("keyword").value;
    sendRequest("autoComplement?keyword=" + keyword);
}

function sendRequest(url) {
    createXMLHttpRequest();
    xmlHttpRequest.open("GET", url, true);
    xmlHttpRequest.onreadystatechange = processResponse;
    xmlHttpRequest.send(null);
}

function processResponse() {
    if (xmlHttpRequest.readyState == 4) {
        if (xmlHttpRequest.status == 200) {
            var responseList = xmlHttpRequest.responseXML.getElementsByTagName("name");
            var productList = document.getElementById("products");
            productList.innerHTML = "";
            var option = null;
            for(var i = 0 ; i < responseList.length; i++){
                option = document.createElement("option");
                option.appendChild(document.createTextNode(responseList[i].firstChild.nodeValue));
                option.setAttribute("value",responseList[i].firstChild.nodeValue);
                productList.appendChild(option);
            }
        }
    }
}