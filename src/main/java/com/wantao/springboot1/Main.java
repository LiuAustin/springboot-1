package com.wantao.springboot1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()//等同于@EnableAutoConfiguration+@ComponentScan(同级包和子包)
@MapperScan(basePackages = {"com.wantao.springboot1.mapper"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
