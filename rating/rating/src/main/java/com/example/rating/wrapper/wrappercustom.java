package com.example.rating.wrapper;

import com.example.rating.model.ratingdto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class wrappercustom {

    String message;
    ratingdto rating;
    List<ratingdto> data;

    }

