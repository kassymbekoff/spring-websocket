package io.github.kassymbekoff.websocket.service;

import io.github.kassymbekoff.websocket.model.Message;
import io.github.kassymbekoff.websocket.model.MessageType;
import io.github.kassymbekoff.websocket.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final MessageRepository messageRepository;

    public LogServiceImpl(final MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> handleMessage(Message message) {
        if (message.getCommand().equals(MessageType.ADD_LOG)) {
            saveLog(message);
            return List.of();
        } else {
            return getLogs();
        }
    }

    @Override
    public void saveLog(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getLogs() {
        return messageRepository.findAll();
    }
}
