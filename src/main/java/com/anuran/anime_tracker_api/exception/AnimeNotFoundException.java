package com.anuran.anime_tracker_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnimeNotFoundException
        extends RuntimeException {

    public AnimeNotFoundException(String message) {
        super(message);
    }
}