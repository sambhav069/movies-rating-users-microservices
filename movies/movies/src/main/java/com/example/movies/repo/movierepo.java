package com.example.movies.repo;

import com.example.movies.model.MovieDto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface movierepo extends ReactiveCrudRepository<MovieDto, Long> {
    Mono<MovieDto> findBymovieId(String id);
}
