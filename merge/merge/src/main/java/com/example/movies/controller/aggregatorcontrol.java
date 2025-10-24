package com.example.movies.controller;

import com.example.movies.model.MovieRatingDto;
import com.example.movies.model.MovieRatingResponceDto;
import com.example.movies.model.UserDetailsWrapper;
import com.example.movies.service.servicemerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/aggregator")
public class aggregatorcontrol {

    @Autowired
    private servicemerge  service;

    @GetMapping("/{id}")
    Mono<UserDetailsWrapper> aggregateUserDetails(@PathVariable("id") Long userId){
        return service.aggregateUserDetails(userId);
    }

}
