package com.example.rating.webClientConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class webconfig {

    @Configuration
    public class MovieWebClientConfig {
        @Bean(name = "movieWebClient")
        public WebClient movieWebClient(WebClient.Builder builder) {
            return builder.baseUrl("http://localhost:8082").build();
        }
    }

    @Configuration
    public class UserWebClientConfig {
        @Bean(name = "userWebClient")
        public WebClient userWebClient(WebClient.Builder builder) {
            return builder.baseUrl("http://localhost:8090").build();
        }
    }
}
