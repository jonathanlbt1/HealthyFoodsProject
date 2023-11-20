package com.example.healthyfoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {"com.example.healthyfoods"})
public class EcoFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoFoodApplication.class, args);
    }

}
