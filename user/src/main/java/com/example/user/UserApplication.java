package com.example.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {

        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(com.example.user.UserApplication.class, args);
    }


}
