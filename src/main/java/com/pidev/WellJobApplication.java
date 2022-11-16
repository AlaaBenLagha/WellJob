package com.pidev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import lombok.extern.slf4j.Slf4j;
import com.pidev.WellJobApplication;
import com.pidev.config.SwaggerConfiguration;






@Slf4j
@EnableAsync
@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class WellJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellJobApplication.class, args);
		log.info("WellJob!!");
	}

}
