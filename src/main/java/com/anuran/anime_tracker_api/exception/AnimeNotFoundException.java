package com.anuran.anime_tracker_api.exception;

public class AnimeNotFoundException
        extends RuntimeException {

    public AnimeNotFoundException(String message) {
        super(message);
    }
}