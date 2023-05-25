package com.signApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SignAppStart {
    public static void main(String[] args) {
        SpringApplication.run( SignAppStart.class );
        System.out.println("Hello!");
    }
}
