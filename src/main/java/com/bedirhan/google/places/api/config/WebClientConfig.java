package com.bedirhan.google.places.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${apikey}")
    private String apikey;

    @Bean
    WebClient.Builder client() {
        return WebClient.builder();
    }

}
