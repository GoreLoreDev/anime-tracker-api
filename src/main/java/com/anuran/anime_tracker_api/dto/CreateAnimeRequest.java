package com.anuran.anime_tracker_api.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateAnimeRequest {

    @NotBlank
    private String title;


    public CreateAnimeRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
