package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRatingResponceDto {
    private Long movieIdDb;       // DB id of movie
    private String movieId;       // business movieId
    private String movieName;
    private String description;

    private Long ratingIdDb;      // DB id of rating
    private Integer userId;
    private Integer rating;
}
