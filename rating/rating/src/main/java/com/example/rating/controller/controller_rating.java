package com.example.rating.controller;

import com.example.rating.model.ratingdto;
import com.example.rating.service.ratingservice;
import com.example.rating.wrapper.wrappercustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ratings")
public class controller_rating {
    @Autowired
    ratingservice ratingservice;

    @GetMapping("/findall")
    Mono<ResponseEntity<wrappercustom>> findAll(){
        return ratingservice.findAll();
    }

    @GetMapping("/user/{userId}")
    public  Mono<ResponseEntity<wrappercustom>> findByuserId(@PathVariable("userId") Integer userId){
        return ratingservice.findByuserId(userId);
    }

    @GetMapping("/find/{user}/{movie}")
    public Mono<ResponseEntity<wrappercustom>> findBymovieIdViauserId(@PathVariable ("user") Integer user , @PathVariable ("movie") String movie ){
        return ratingservice.findBymovieIdViauserId(user,movie);
    }

    @PostMapping
    public Mono<ratingdto> add(@RequestBody ratingdto ratingdto){
        return ratingservice.add(ratingdto);
    }

    @PutMapping
    public Mono<ResponseEntity<wrappercustom>> update(@RequestBody ratingdto ratingdto){
        return ratingservice.update(ratingdto);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<wrappercustom>> delete(@PathVariable ("id") Long id){
        return ratingservice.delete(id);
    }
}
