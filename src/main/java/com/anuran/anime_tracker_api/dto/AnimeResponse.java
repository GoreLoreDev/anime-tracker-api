
//We use AnimeResponse to separate our API contract from our domain model.
// This prevents internal implementation details from leaking to clients and allows the domain
// model and API responses to evolve independently.

package com.anuran.anime_tracker_api.dto;

import com.anuran.anime_tracker_api.model.AnimeStatus;

public class AnimeResponse {
    private long id;
    private String title;

    private AnimeStatus status;

    public AnimeResponse(Long id, String title, AnimeStatus status) {
        this.id = id;
        this.title = title;
        this.status=status;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public AnimeStatus getStatus() {
        return status;
    }
}
