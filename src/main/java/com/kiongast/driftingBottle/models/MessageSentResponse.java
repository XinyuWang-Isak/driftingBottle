package com.kiongast.driftingBottle.models;

import java.io.Serializable;

public class MessageSentResponse implements Serializable {

    public static final long serialVersionUID = 1L;

    private String serverResponse;
    private Boolean success;

    public MessageSentResponse(Boolean success) {
        this.success = success;
    }

    public MessageSentResponse() {
    }

    public MessageSentResponse(String serverResponse, Boolean success) {
        this.serverResponse = serverResponse;
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
}
