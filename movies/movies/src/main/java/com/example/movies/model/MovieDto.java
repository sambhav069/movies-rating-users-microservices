package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("movies")
public class MovieDto {
    @Id
    private Long id;

    @Column("movie_id")
    private String movieId;

    @Column("movie_name")
    private String movieName;

    @Column("description")
    private String description;
}
