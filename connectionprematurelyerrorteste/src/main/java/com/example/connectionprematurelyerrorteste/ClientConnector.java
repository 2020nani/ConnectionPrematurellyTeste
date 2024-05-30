package com.example.connectionprematurelyerrorteste;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ClientConnector {

    private final WebClient webClient;

    public ClientConnector(@Qualifier("clientGraphql") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getResponse() {
        return webClient.post()
                .uri("http://localhost:8080/graphql")
                .retrieve()
                .bodyToMono(String.class);

    }
}
