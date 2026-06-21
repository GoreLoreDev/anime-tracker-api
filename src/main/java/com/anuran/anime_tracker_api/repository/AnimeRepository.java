package com.anuran.anime_tracker_api.repository;

import com.anuran.anime_tracker_api.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository
        extends JpaRepository<Anime, Long> {

}