package com.example.movies.service;

import com.example.movies.model.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;


import java.util.List;

@Service
public class servicemerge {

    private final WebClient userClient;
    private final WebClient ratingClient;
    private final WebClient movieClient;

    public servicemerge(
            WebClient.Builder userClient,
            WebClient.Builder ratingClient,
            WebClient.Builder movieClient) {
        this.userClient = userClient.baseUrl("http://USER").build();
        this.ratingClient = ratingClient.baseUrl("http://RATING").build();
        this.movieClient = movieClient.baseUrl("http://MOVIES").build();
    }

    @KafkaListener(topics = "movie-msg", groupId = "movie")
    public void consumeMovieMessage(MovieKafkaDto message) {
        System.out.println("==> Received Kafka Message: " + message.toString());
    }


    public Mono<UserDetailsWrapper> aggregateUserDetails(Long userId) {
        return userClient.get()
                .uri("/users/{id}", userId)
                .retrieve()
                .bodyToMono(userDto.class)
                .flatMap(user ->
                        ratingClient.get()
                                .uri("/ratings/user/{id}", userId)
                                .retrieve()
                                .bodyToMono(ratingDto.class)
                                .map(ratingDto::getData)
                                .flatMap(ratings ->
                                        Flux.fromIterable(ratings)
                                                .flatMap(rating ->
                                                        movieClient.get()
                                                                .uri("/movies/{id}", rating.getMovieId())
                                                                .retrieve()
                                                                .bodyToMono(movieDto.class)
                                                )
                                                .collectList()
                                                .map(movies -> new UserDetailsWrapper(user, ratings, movies))
                                )
                );
    }


}