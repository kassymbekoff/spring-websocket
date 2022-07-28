package io.github.kassymbekoff.websocket.controller;

import io.github.kassymbekoff.websocket.model.Message;
import io.github.kassymbekoff.websocket.service.LogService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final LogService logService;

    public MessageController(final SimpMessagingTemplate messagingTemplate, final LogService logService){
        this.messagingTemplate = messagingTemplate;
        this.logService = logService;
    }

    @MessageMapping("/sendCommand")
    public void sendCommand(Message message) {
        List<Message> messages = logService.handleMessage(message);
        if (messages.size() > 0){
            messagingTemplate.convertAndSend("/topic/logs", messages);
        }
    }
}
