package com.anuran.anime_tracker_api.model;

public class Anime {
    private Long id;
    private String title;

    public Anime(Long id, String title) {
        this.id = id;
        this.title = title;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }
}
