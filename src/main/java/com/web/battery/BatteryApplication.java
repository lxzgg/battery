package com.web.battery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.web.battery.mapper")
public class BatteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatteryApplication.class, args);
    }
}
