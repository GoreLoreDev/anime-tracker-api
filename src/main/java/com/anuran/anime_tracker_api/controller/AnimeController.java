package com.anuran.anime_tracker_api.controller;

import com.anuran.anime_tracker_api.model.Anime;
import com.anuran.anime_tracker_api.sevice.AnimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

}
