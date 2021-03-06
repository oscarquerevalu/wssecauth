package com.ripley.ws.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.ripley.ws.repo")
@EntityScan("com.ripley.ws.model")
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})//bypass this spring boot security mechanism.
@SpringBootApplication(scanBasePackages = {"com.ripley.ws"})
@PropertySource("classpath:application.properties")
public class Application extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
