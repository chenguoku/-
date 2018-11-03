package com.zd.zd1_0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zd.zd1_0.mapper")
public class Zd10Application {

    public static void main(String[] args) {
        SpringApplication.run(Zd10Application.class, args);
    }
}
