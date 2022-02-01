package com.kirstreltsov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kirstreltsov")
public class ShortlinkApp{
    
    public static void main(String[] args) {
        SpringApplication.run(ShortlinkApp.class, args);
    }
}