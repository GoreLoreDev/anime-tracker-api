package com.anuran.anime_tracker_api.service;

import com.anuran.anime_tracker_api.model.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    public List<Anime> getAllAnime() {
        return List.of(
                new Anime(1L, "Attack on Titan"),
                new Anime(2L, "Death Note"),
                new Anime(3L, "Fullmetal Alchemist")
        );
    }
}