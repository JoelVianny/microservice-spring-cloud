package com.example.eurekacharacteristic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaCharacteristicApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCharacteristicApplication.class, args);
    }

}
