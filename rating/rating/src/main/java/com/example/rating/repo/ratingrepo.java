package com.example.rating.repo;

import com.example.rating.model.ratingdto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface ratingrepo extends ReactiveCrudRepository<ratingdto, Long> {
    Flux<ratingdto> findAllByUserId(Integer userId);

    Mono<ratingdto> findByUserIdAndMovieId(Integer userId, String movieId);
}
