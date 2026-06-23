package com.anuran.anime_tracker_api.dto;

import com.anuran.anime_tracker_api.model.AnimeStatus;

public class UpdateAnimeStatusRequest {
    private AnimeStatus status;

    public AnimeStatus getStatus() {
        return status;
    }

    public void setStatus(AnimeStatus status) {
        this.status = status;
    }
}
