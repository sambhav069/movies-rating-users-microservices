package com.example.rating.service;

import com.example.rating.model.MovieClientDto;
import com.example.rating.model.UserClientDto;
import com.example.rating.model.ratingdto;
import com.example.rating.repo.ratingrepo;

import com.example.rating.wrapper.wrappercustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ratingservice {

    @Autowired
    private ratingrepo ratingrepo;
    @Autowired
    @Qualifier("movieWebClient")
    private WebClient movieWebClient;

    @Autowired
    @Qualifier("userWebClient")
    private WebClient userWebClient;


//    private Mono<MovieClientDto> checkMovie(ratingdto ratingdto) {
//        return movieWebClient.get()
//                .uri("/movies/{id}", ratingdto.getMovieId())
//                .retrieve()
//                .bodyToMono(MovieClientDto.class);
//
//    }

//    private Mono<UserClientDto> checkUser(ratingdto ratingdto) {
//        return userWebClient.get()
//                .uri("/users/{id}", ratingdto.getUserId())
//                .retrieve()
//                .bodyToMono(UserClientDto.class);
//    }

    public Mono<ResponseEntity<wrappercustom>> findAll() {
        return ratingrepo.findAll()
                .collectList()
                .flatMap(all -> {
                    if (all.isEmpty()) {
                        return Mono.just(ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(new wrappercustom("nothing here",null, null)));
                    } else {
                        return Mono.just(ResponseEntity
                                .status(HttpStatus.FOUND)
                                .body(new wrappercustom(null, null,all)));
                    }
                });
    }

    public Mono<ResponseEntity<wrappercustom>> findByuserId(Integer userId) {
        return ratingrepo.findAllByUserId(userId)
                .collectList()
                .flatMap(list -> {
                    if (list.isEmpty()) {
                        return Mono.just(ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(new wrappercustom("No ratings found", null,null)));
                    } else {
                        return Mono.just(ResponseEntity
                                .status(HttpStatus.OK)
                                .body(new wrappercustom(null, null,list)));
                    }
                });
    }

    public Mono<ResponseEntity<wrappercustom>> findBymovieIdViauserId(Integer userId, String movieId) {
        return ratingrepo.findByUserIdAndMovieId(userId, movieId)
                .map(one -> ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(new wrappercustom(null,one, null)))
                .switchIfEmpty(Mono.just(
                        ResponseEntity
                                .status(HttpStatus.NO_CONTENT)
                                .body(new wrappercustom("nothing is related to your request",null,null))
                ));
    }

    public Mono<ratingdto> add(ratingdto ratingdto) {



        return ratingrepo.save(ratingdto);
//        return Mono.zip(checkMovie(ratingdto), checkUser(ratingdto))
//                .flatMap(tuple ->
//                        ratingrepo.save(ratingdto)
//                                .map(saved -> ResponseEntity
//                                        .status(HttpStatus.CREATED)
//                                        .body(new wrappercustom(null, saved ,null)))
//                )
//                .switchIfEmpty(Mono.just(
//                        ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                .body(new wrappercustom("Either Movie or User not found",null, null))
//                ));
    }

    public Mono<ResponseEntity<wrappercustom>> update ( ratingdto ratingdto) {
        return ratingrepo.save(ratingdto)
                .map(one -> {
                    return  ResponseEntity.status(HttpStatus.CREATED).body(new wrappercustom(null, one,null));
                })
                .switchIfEmpty(
                        Mono.just(
                                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new wrappercustom("give correct values", null,null))
                        )
                );
    }

    public Mono<ResponseEntity<wrappercustom>> delete(Long id) {
        return ratingrepo.findById(id)
                .flatMap(one ->
                        ratingrepo.delete(one)
                                .then(Mono.just(
                                        ResponseEntity.status(HttpStatus.NO_CONTENT)
                                                .body(new wrappercustom(null, one,null))
                                ))
                )
                .switchIfEmpty(
                        Mono.just(
                                ResponseEntity.status(HttpStatus.NOT_FOUND)
                                        .body(new wrappercustom("No rating found to delete", null,null))
                        )
                );
    }


}