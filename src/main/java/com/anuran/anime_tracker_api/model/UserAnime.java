package com.anuran.anime_tracker_api.model;

import jakarta.persistence.*;

@Entity
public class UserAnime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    AnimeStatus status;

    Integer rating;

    @ManyToOne
    User user;//hibernate will create user.id automatically
    // when it sees that id is the primary key of user

    @ManyToOne
    Anime anime;


}
