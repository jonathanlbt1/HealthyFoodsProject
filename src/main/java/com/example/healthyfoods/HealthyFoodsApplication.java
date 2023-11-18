package com.example.healthyfoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {"com.example.healthyfoods"})
public class HealthyFoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthyFoodsApplication.class, args);
    }

}
