package com.example.rating.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserClientDto {
    private Long id;
    private String name;
    private String username;
    private String email;
}