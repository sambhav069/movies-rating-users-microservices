package com.example.user.service;

import com.example.user.model.userDto;
import com.example.user.wrapper.wrappercustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class userService {

    @Autowired
    private WebClient webClient;

    public Mono<ResponseEntity<wrappercustom>> find() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(userDto.class)
                .collectList()
                .map(users -> ResponseEntity.ok(new wrappercustom(null , users)));
    }


    public Mono<ResponseEntity<wrappercustom>> finduser(Long id) {
        return webClient.get()
                .uri("/users/{id}" ,id)
                .retrieve()
                .bodyToMono(userDto.class)
                .map(
                        one -> {
                            return ResponseEntity.status(HttpStatus.FOUND).
                                    body(new wrappercustom(null , one));
                        }
                ).
                switchIfEmpty(
                        Mono.just(
                                ResponseEntity.status(HttpStatus.NO_CONTENT)
                                        .body(
                                                new wrappercustom(
                                                        "nothing here " , null
                                                )                                        )
                        )
                );
    }


}
