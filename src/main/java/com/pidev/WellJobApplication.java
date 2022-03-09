package com.pidev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.slf4j.Slf4j;
import com.pidev.WellJobApplication;


@SpringBootApplication
@Slf4j
public class WellJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellJobApplication.class, args);
		log.info("WellJob!!");
	}

}
