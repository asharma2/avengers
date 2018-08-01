package com.avengers.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.avengers.fc" })
public class ForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForecastApplication.class);
	}
}
