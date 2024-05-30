package com.example.connectionprematurelyerrortesteserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

//@SpringBootApplication
public class ConnectionprematurelyerrortesteserverApplication {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
		server.createContext("/graphql", new PrematureCloseHandler());
		server.setExecutor(null);
		server.start();
		System.out.println("Server rodando na porta 8080...");
	}

	static class PrematureCloseHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			if("POST".equals(exchange.getRequestMethod())){
				String response = "Partial Response Content";
				/* Fechar a conexao prematuramente*/
				exchange.getResponseBody().close();
				exchange.close();
				exchange.sendResponseHeaders(200, response.length());
				OutputStream os = exchange.getResponseBody();
				os.write(response.getBytes());
				os.flush();
			}
		}
	}

}
