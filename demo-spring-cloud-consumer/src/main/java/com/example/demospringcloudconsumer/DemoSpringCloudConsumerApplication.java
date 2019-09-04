package com.example.demospringcloudconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Configuration
@EnableCircuitBreaker
public class DemoSpringCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudConsumerApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/consume")
    @HystrixCommand(fallbackMethod = "fallback")
    public ResponseEntity consume() {
        return restTemplate().getForEntity("http://demo-service/hello", Map.class);
    }

    public ResponseEntity fallback() {
        return ResponseEntity.badRequest().body("server busy!");
    }
}
