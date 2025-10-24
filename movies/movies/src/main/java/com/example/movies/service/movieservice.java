package com.example.movies.service;

import com.example.movies.avroDto.MovieKafkaDto;
import com.example.movies.model.MovieDto;
import com.example.movies.repo.movierepo;
import com.example.movies.wrapper.wrappercustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class movieservice {
    @Autowired
    private movierepo movierepo;

    @Autowired
    private KafkaTemplate<String, MovieKafkaDto> kafkaTemplate;

    public Mono <ResponseEntity<wrappercustom>> findall(){
        return movierepo.findAll()
                .collectList()
                .map(
                        all -> {
                            return  ResponseEntity.status(HttpStatus . FOUND)
                                    .body(new wrappercustom(
                                            null , all
                                    ));
                        }
                ).switchIfEmpty(
                        Mono.just(
                                ResponseEntity.status(HttpStatus.NO_CONTENT)
                                        .body(new wrappercustom(
                                                "NO content here ", null
                                        ))
                        )
                );
    }

    public Mono<ResponseEntity<wrappercustom>> findBymovieId(String id){
        return movierepo.findBymovieId(id)
                .map(
                        one -> {
//                            kafkaTemplate.send("movie-msg" , MovieKafkaDto);
                            return  ResponseEntity.status(HttpStatus.FOUND)
                                    .body(new wrappercustom(
                                            null , one
                                    ));
                        }
                ).switchIfEmpty(
                        Mono.just(
                                ResponseEntity.status(HttpStatus.NOT_FOUND)
                                        .body(new wrappercustom(
                                                "NO content here ", null
                                        ))
                        )

                );
    }

    public Mono<MovieDto> newMovie(MovieDto movieDto) {
        return movierepo.save(movieDto);
    }
}
