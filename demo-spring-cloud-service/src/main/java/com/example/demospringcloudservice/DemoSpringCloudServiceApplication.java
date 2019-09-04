package com.example.demospringcloudservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DemoSpringCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudServiceApplication.class, args);
    }

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public ResponseEntity hello() {
        Map info = new HashMap<String, Object>();
        info.put("data", "hello world");
        info.put("client", client);
        return ResponseEntity.ok().body(info);
    }
}
