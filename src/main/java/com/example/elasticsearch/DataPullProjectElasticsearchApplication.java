package com.example.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DataPullProjectElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataPullProjectElasticsearchApplication.class, args);
	}

}
