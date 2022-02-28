package com.pidev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.pidev.WellJobApplication;


@EnableSwagger2
@SpringBootApplication
@Slf4j
public class WellJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellJobApplication.class, args);
		log.info("WellJob!!");
	}

}
