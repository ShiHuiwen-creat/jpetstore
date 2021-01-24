var xmlHttpRequest;
var getListPrice;
var quantity;
var getItemId;
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

function refreshCart(itemId,listPrice) {
    quantity = parseInt(document.getElementById("quantityOf" + itemId).value);
    var total = document.getElementById("totalOf" + itemId);
    total.innerHTML ="";
    if (quantity > 0)
    {
        getListPrice = parseFloat(listPrice);
        getItemId = itemId.toString();
        sendRequest("autoRefreshCart?itemId=" + itemId +"&quantity=" + quantity);
    }
    else alert("Please enter a correct quantity!");
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
            var msg = xmlHttpRequest.responseXML.getElementsByTagName("msg")[0].firstChild.data;
            var getSubtotal = xmlHttpRequest.responseXML.getElementsByTagName("SubTotal")[0].firstChild.data;
            if (msg == "Update successfully") {
                var total = document.getElementById("totalOf" + getItemId);
                total.innerHTML = toMoney(getListPrice * quantity);
                var SubTotal = document.getElementById("SubTotal");
                SubTotal.innerHTML = "Sub Total: " + toMoney(parseFloat(getSubtotal));
            }
        }
    }
}

function toMoney(num) {
    num = num.toFixed(2);
    num = parseFloat(num);
    num = '$' + num.toLocaleString();
    return num;
}