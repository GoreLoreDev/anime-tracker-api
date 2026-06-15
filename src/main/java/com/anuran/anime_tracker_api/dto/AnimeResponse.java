package com.anuran.anime_tracker_api.dto;

public class AnimeResponse {
    private long id;
    private String title;

    public AnimeResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
