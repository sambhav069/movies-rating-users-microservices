package com.example.movies.controller;

import com.example.movies.model.MovieDto;
import com.example.movies.service.movieservice;
import com.example.movies.wrapper.wrappercustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")

public class control {

    @Autowired
    private movieservice movieservice;

    @GetMapping("/findall")
    public Mono<ResponseEntity<wrappercustom>> findall(){
    return  movieservice.findall();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<wrappercustom>> findById(@PathVariable String id){
        return movieservice.findBymovieId(id);
    }
    @PostMapping
    public Mono<MovieDto> newMovie(@RequestBody MovieDto movieDto){
        return movieservice.newMovie(movieDto);
    }
}
