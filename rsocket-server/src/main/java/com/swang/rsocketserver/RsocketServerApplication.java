package com.swang.rsocketserver;

import io.rsocket.core.Resume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.rsocket.server.RSocketServerCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class RsocketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsocketServerApplication.class, args);
	}

	@Bean
	public RSocketServerCustomizer rSocketServerCustomizer() {
		return customizer -> customizer
				.resume(new Resume().sessionDuration(Duration.ofMinutes(20)));
	}
}
