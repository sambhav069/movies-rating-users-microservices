package com.example.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRatingDto {
    private Integer userId;
    private Integer rating;
    private String movieId;
    private String movieName;
    private String description;
}
