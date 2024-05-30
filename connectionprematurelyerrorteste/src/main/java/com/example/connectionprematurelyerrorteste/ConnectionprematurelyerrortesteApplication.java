package com.example.connectionprematurelyerrorteste;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ConnectionprematurelyerrortesteApplication {

	@Bean("clientGraphql")
	public WebClient getWebClient(){
		return WebClient.builder()
				/*.clientConnector(new ReactorClientHttpConnector(HttpClient.create()
						.tcpConfiguration(client -> client.option(
										ChannelOption.SO_KEEPALIVE, true)
								.doOnConnected(conn -> conn
										.addHandlerLast(new ReadTimeoutHandler(1000, TimeUnit.MILLISECONDS))
										.addHandlerLast(new WriteTimeoutHandler(1000, TimeUnit.MILLISECONDS))
								)
						)
				))*/
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConnectionprematurelyerrortesteApplication.class, args);
	}

}
