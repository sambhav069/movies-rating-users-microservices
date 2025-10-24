package com.example.movies.webClient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

//    @Bean(name = "userClient")
//    @LoadBalanced
//    public WebClient userClient(
//            Builder builder) {
//        return builder.baseUrl("http://localhost:8090").build();
//    }

    @Bean
    @LoadBalanced
    public WebClient.Builder ratingClient() {
        return WebClient.builder();
    }

//    @Bean(name = "movieClient")
//    @LoadBalanced
//    public WebClient movieClient(
//                                 Builder builder) {
//        return builder.baseUrl("http://localhost:8082").build();
//    }
}