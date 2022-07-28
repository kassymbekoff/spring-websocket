const url = 'http://localhost:8080';
let stopmClient;

function connectToServer(){
    console.log("connecting to chat ...");
    let socket = new SockJS(url + '/sendCommand');
    stopmClient = Stomp.over(socket);
    stopmClient.connect({}, function (frame) {
        console.log("connected to: " + frame);
        stopmClient.subscribe("/topic/logs", function (response) {
            $("#logList").html('')
            let data = JSON.parse(response.body);
            var logs = '';
            for(i = 0; i < data.length; i++) {
                logs = logs + '<li>' + data[i].content + '</li>';
            }
            logs = '<ul>' + logs + '</ul>';
            $("#logList").append(logs);
            console.log(logs);
        });
    });
}

function sendCommand(content) {
    if(content) {
        stopmClient.send("/app/sendCommand", {}, JSON.stringify({
            command: "addLog",
            content: content
        }));
    }
}

function getLogs() {
    stopmClient.send("/app/sendCommand", {}, JSON.stringify({
        command: "logs",
        content: ""
    }));
}