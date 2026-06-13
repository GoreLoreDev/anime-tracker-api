package com.anuran.anime_tracker_api.dto;

public class MessageResponse {
    private String message;


    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
