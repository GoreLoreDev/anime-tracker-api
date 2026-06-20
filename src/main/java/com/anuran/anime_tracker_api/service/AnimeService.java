package com.anuran.anime_tracker_api.service;

import com.anuran.anime_tracker_api.exception.*;
import com.anuran.anime_tracker_api.model.Anime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimeService {

    private final List<Anime> animeList = new ArrayList<>();

    private Long nextId= 4L;



    public AnimeService(){

                animeList.add(new Anime(1L, "Attack on Titan"));
                animeList.add( new Anime(2L, "Death Note"));
                animeList.add(new  Anime(3L, "Fullmetal Alchemist"));

    }
    public List<Anime> getAllAnime() {
        return animeList;
    }

    public Anime createAnime(String title){
        Anime anime=new Anime(nextId, title);
        nextId++;
        animeList.add(anime);

        return anime;
    }

    public Anime getAnimeById(long id){
        Anime foundAnime=animeList.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (foundAnime!=null){
            return foundAnime;
        }
        else {
            throw new AnimeNotFoundException(
                    "Anime with id " + id + " not found"
            );
        }
    }

    public void deleteAnime(Long id){

       Anime anime=getAnimeById(id);

       animeList.remove(anime);


    }

    public Anime updateAnime(Long id, String title){
        Anime anime=getAnimeById(id);

        anime.setTitle(title);

        return anime;
    }
}