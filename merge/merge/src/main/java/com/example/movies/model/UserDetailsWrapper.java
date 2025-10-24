package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDetailsWrapper {
    private userDto user;
    private List<ratingDto.Item> ratings;
    private List<movieDto> movies;
}

