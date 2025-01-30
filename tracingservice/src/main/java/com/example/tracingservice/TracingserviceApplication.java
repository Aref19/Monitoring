package com.example.tracingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableFeignClients
public class TracingserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracingserviceApplication.class, args);
    }

}
