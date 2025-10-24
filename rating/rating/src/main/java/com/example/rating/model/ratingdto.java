package com.example.rating.model;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("rating_movies")
public class ratingdto {
    @Id
    private Long id;

    @Column("userid")
    private Integer userId;

    private Integer rating;

    @Column("movieid")
    private String movieId;
}