package com.sparta.andbackoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AndBackOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndBackOfficeApplication.class, args);
    }

}
