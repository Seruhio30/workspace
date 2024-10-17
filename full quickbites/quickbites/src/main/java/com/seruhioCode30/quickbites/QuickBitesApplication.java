package com.seruhioCode30.quickbites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.seruhioCode30.quickbites.model"})
@EnableJpaRepositories(basePackages = {"com.seruhioCode30.quickbites.repository"})
public class QuickBitesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickBitesApplication.class, args);
	}

}
