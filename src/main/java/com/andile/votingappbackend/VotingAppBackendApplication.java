package com.andile.votingappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VotingAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingAppBackendApplication.class, args);
	}

}
