package io.github.kassymbekoff.websocket.service;

import io.github.kassymbekoff.websocket.model.Message;

import java.util.List;

public interface LogService {
    void saveLog(Message message);
    List<Message> getLogs();
    List<Message> handleMessage(Message message);
}
