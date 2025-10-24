package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieKafkaDto {

    private Long id;


    private String movieId;


    private String movieName;


    private String description;
}
