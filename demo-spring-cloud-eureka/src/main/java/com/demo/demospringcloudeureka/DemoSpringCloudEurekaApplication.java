package com.demo.demospringcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoSpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudEurekaApplication.class, args);
    }

}
