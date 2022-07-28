package io.github.kassymbekoff.websocket.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MessageType {
    @JsonProperty("addLog")
    ADD_LOG("addLog"),
    @JsonProperty("logs")
    LOGS("logs");

    public final String label;

    MessageType(String label){
        this.label = label;
    }
}
