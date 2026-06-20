package com.anuran.anime_tracker_api.controller;

import com.anuran.anime_tracker_api.dto.AnimeResponse;
import com.anuran.anime_tracker_api.dto.CreateAnimeRequest;
import com.anuran.anime_tracker_api.dto.UpdateAnimeRequest;
import com.anuran.anime_tracker_api.model.Anime;
import com.anuran.anime_tracker_api.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }
    // not creating AnimeService service = new AnimeService();
    //Spring creates the service.
    //
    //Spring passes it into the controller.
    //
    //This is dependency injection.

    @GetMapping("/anime")
    public List<AnimeResponse> getAllAnime() {

        List<Anime> animeList = animeService.getAllAnime();

        return animeList.stream()
                .map(anime -> new AnimeResponse(
                        anime.getId(),
                        anime.getTitle()
                ))
                .toList();
    }


    @PostMapping("/anime")
    public AnimeResponse createAnime(
            @RequestBody CreateAnimeRequest request) {


        Anime anime=animeService.createAnime(request.getTitle());

        return new AnimeResponse(
                anime.getId(),
                anime.getTitle()
        );
    }

    @GetMapping("/anime/{id}")
    public AnimeResponse getAnimeById(
            @PathVariable Long id) {
        Anime anime=animeService.getAnimeById(id);
        AnimeResponse ar=new AnimeResponse(anime.getId(), anime.getTitle());

        return ar;
    }

    @DeleteMapping("/anime/{id}")
    public void deleteAnime(
            @PathVariable Long id) {
        animeService.deleteAnime(id);
    }

    @PutMapping("/anime/{id}")
    public AnimeResponse updateAnime(
            @PathVariable Long id,
            @RequestBody UpdateAnimeRequest request){
        Anime anime=animeService.updateAnime(id, request.getTitle());
        AnimeResponse ar=new AnimeResponse(anime.getId(), anime.getTitle());
        return ar;
    }

}
