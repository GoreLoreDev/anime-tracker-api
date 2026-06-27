package com.anuran.anime_tracker_api.service;

import com.anuran.anime_tracker_api.exception.*;
import com.anuran.anime_tracker_api.model.Anime;
import com.anuran.anime_tracker_api.model.AnimeStatus;
import com.anuran.anime_tracker_api.repository.AnimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.util.List;




@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }



    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public Anime createAnime(String title){
        Anime anime=new Anime(null, title);


        return animeRepository.save(anime);
    }

    public Anime getAnimeById(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() ->
                        new AnimeNotFoundException(
                                "Anime with id " + id + " not found"
                        ));
    }

    public void deleteAnime(Long id) {
        Anime anime = getAnimeById(id);
        animeRepository.delete(anime);
    }

    public Anime updateAnime(Long id, String title) {
        Anime anime = getAnimeById(id);

        anime.setTitle(title);

        return animeRepository.save(anime);
    }
    public Anime updateAnimeStatus(Long id,
                                   AnimeStatus status) {

        Anime anime = getAnimeById(id);

        anime.setStatus(status);

        return animeRepository.save(anime);
    }

    public List<Anime> searchAnimeByTitle(String title) {
        return animeRepository
                .findByTitleContainingIgnoreCase(title);
    }

    public List<Anime> getAnimePage(
            int page,
            int size) {
        Page<Anime> animePage =
                animeRepository.findAll(
                        PageRequest.of(page, size)
                );

        return animePage.getContent();

    }
    public List<Anime> getAnimeSorted(
            String sortBy) {

        return animeRepository.findAll(
                Sort.by(sortBy)
        );
    }



}