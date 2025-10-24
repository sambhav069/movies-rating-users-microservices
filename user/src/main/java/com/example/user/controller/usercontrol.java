package com.example.user.controller;

import com.example.user.service.userService;
import com.example.user.wrapper.wrappercustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class usercontrol {

    @Autowired
    private userService userService;

    @GetMapping("/find")
    public Mono<ResponseEntity<wrappercustom>> find()
    {
        return userService.find();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<wrappercustom>> finder(@PathVariable Long id)
    {
        return userService.finduser(id);
    }
}
