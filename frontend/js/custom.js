let $btnSendCommand;
let $btnGetLogs;
let $content;
let $logs;

function init() {
    cacheDOM();
    bindEvents();
    connectToServer()
}

function bindEvents() {
    $btnSendCommand.on('click', sendCommandEvent.bind(this));
    $btnGetLogs.on('click', getLogsEvent.bind(this))
}

function cacheDOM() {
    $btnSendCommand = $('#sendCommand');
    $btnGetLogs     = $('#getLogs');
    $logs           = $('#logList').find('ul');
    $content        = $("#content");
}

function sendCommandEvent() {
    sendCommand($content.val());
    $content.val('');
}

function getLogsEvent() {
    getLogs()
}

init();