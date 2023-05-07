let stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#messages").html("");
}

function connect() {
    console.log("Trying to connect");
    let socket = new SockJS("/message-websocket");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log("Connected: " + frame);
            stompClient.subscribe('/topic/message', function (message) {
                let mess = JSON.parse(message.body);
                showMessage(mess.name + ': ' + mess.message);
            })
        }
    )
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    showMessage($("#name").val() + ': ' + $("#message").val());
    stompClient.send("/app/message", {}, JSON.stringify({'content': $("#message").val(), 'name': $("#name").val()}))
}

function showMessage(message) {
    $("#messages").append("<tr><td>" + message + "</td></tr>")
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendMessage();
    });
})