package com.anuran.anime_tracker_api.controller;

import com.anuran.anime_tracker_api.dto.AnimeResponse;
import com.anuran.anime_tracker_api.dto.CreateAnimeRequest;
import com.anuran.anime_tracker_api.dto.UpdateAnimeRequest;
import com.anuran.anime_tracker_api.dto.UpdateAnimeStatusRequest;
import com.anuran.anime_tracker_api.model.Anime;
import com.anuran.anime_tracker_api.model.AnimeSortField;
import com.anuran.anime_tracker_api.service.AnimeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Stream;

@RestController
public class AnimeController {

    private AnimeResponse toResponse(Anime anime){

        AnimeResponse ar=new AnimeResponse(anime.getId(), anime.getTitle(), anime.getStatus());
        return ar;
    }
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
                        anime.getTitle(),
                        anime.getStatus()
                ))
                .toList();
    }


    @PostMapping("/anime")
    public AnimeResponse createAnime(
            @Valid @RequestBody CreateAnimeRequest request) {

        Anime anime = animeService.createAnime(request.getTitle());

        return new AnimeResponse(
                anime.getId(),
                anime.getTitle(),
                anime.getStatus()
        );
    }

    @GetMapping("/anime/{id}")
    public AnimeResponse getAnimeById(
            @PathVariable Long id) {
        Anime anime=animeService.getAnimeById(id);

        return toResponse(anime);
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
        return toResponse(anime);
    }
    @PutMapping("/anime/{id}/status")
    public AnimeResponse updateAnimeStatus(
            @PathVariable Long id,
            @RequestBody UpdateAnimeStatusRequest request) {

        Anime anime =
                animeService.updateAnimeStatus(
                        id,
                        request.getStatus()
                );

        return toResponse(anime);
    }

    @GetMapping("/anime/search")
    public List<AnimeResponse> searchAnime(
            @RequestParam String title) {
        List <Anime> animeList= animeService.searchAnimeByTitle(title);
        return animeList.stream().map(this::toResponse).toList();
    }
    @GetMapping("/anime/page")
    public List<AnimeResponse> getAnimePage(
            @RequestParam int page,
            @RequestParam int size) {

        List<Anime> animeList =
                animeService.getAnimePage(
                        page,
                        size
                );

        return animeList.stream()
                .map(this::toResponse)
                .toList();
    }

        @GetMapping("/anime/sorted")
        public List<AnimeResponse> getAnimeSorted(
                @RequestParam AnimeSortField sortBy) {

            List<Anime> animeList =
                    animeService.getAnimeSorted(sortBy.getFieldName());

            return animeList.stream()
                    .map(this::toResponse)
                    .toList();
        }
}
