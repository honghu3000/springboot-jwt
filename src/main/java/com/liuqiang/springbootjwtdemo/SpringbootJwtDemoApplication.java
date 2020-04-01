package com.liuqiang.springbootjwtdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liuqiang.springbootjwtdemo.mapper")
public class SpringbootJwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJwtDemoApplication.class, args);
    }

}
