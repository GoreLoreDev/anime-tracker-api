

package com.anuran.anime_tracker_api.model;

import jakarta.persistence.*;

import com.anuran.anime_tracker_api.model.AnimeStatus;

@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private AnimeStatus status;

    public Anime(Long id, String title) {
        this.id = id;
        this.title = title;
        this.status=AnimeStatus.PLAN_TO_WATCH;
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


    //Hibernate/JPA needs to be able to create objects itself.
    // if it needs to do something likeAnime anime = new Anime(); then it needs this no arg constructor
    public Anime() {

    }

    public AnimeStatus getStatus() {
        return status;
    }

    public void setStatus(AnimeStatus status) {
        this.status = status;
    }
}

