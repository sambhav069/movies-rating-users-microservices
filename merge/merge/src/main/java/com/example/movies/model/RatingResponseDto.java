package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingResponseDto {
    private Long id;
    private Integer userId;
    private Integer rating;
    private String movieId;
}
