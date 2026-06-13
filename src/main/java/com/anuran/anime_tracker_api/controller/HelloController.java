package com.anuran.anime_tracker_api.controller;

import com.anuran.anime_tracker_api.dto.MessageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// It marks a class as a REST controller so Spring can detect it and use its methods to handle
// HTTP requests and return HTTP responses.
public class HelloController {
    @GetMapping("/hello")
    public MessageResponse sayHello() {
        return new MessageResponse("Hello from Anime Tracker API!");
    }
}
