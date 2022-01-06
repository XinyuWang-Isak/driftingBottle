package com.kiongast.driftingBottle.models;

import java.io.Serializable;
import java.util.List;

public class MessageReceivedResponse implements Serializable {

    public static final long serialVersionUID = 1L;


    private String serverResponse;
    private List<Message> messages;
    private Boolean success;

    public MessageReceivedResponse(Boolean success) {
        this.success = success;
    }

    public MessageReceivedResponse(String serverResponse, List<Message> messages, Boolean success) {
        this.serverResponse = serverResponse;
        this.messages = messages;
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(String serverResponse) {
        this.serverResponse = serverResponse;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
