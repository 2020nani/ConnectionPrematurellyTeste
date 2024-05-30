package com.example.connectionprematurelyerrorteste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/teste")
public class ConnectionPrematurelyTesteController {
    private final ClientConnector clientConnector;

    public ConnectionPrematurelyTesteController(ClientConnector clientConnector) {
        this.clientConnector = clientConnector;
    }

    @GetMapping
    public Mono<String> getConnectionPrematurelyTeste() {
        return clientConnector.getResponse();
    }
}
