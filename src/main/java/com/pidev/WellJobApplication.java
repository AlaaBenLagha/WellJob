package com.pidev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;


@EnableWebMvc
@EnableScheduling
@Slf4j
@SpringBootApplication
public class WellJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellJobApplication.class, args);
		log.info("WellJob!!");
	}

}
