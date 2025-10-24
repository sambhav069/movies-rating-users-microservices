package com.example.movies.model;
//com.example.movies.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class movieDto {

    @JsonProperty("data")
    private Item data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private Long id;
        private String movieId;
        private String movieName;
        private String description;
    }
}