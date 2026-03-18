package com.maliksalimov.my_spring_portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MySpringPortfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringPortfolioApplication.class, args);
    }

}
