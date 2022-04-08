package com.yi.enhancement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.yi.enhancement.mapper")
@SpringBootApplication
public class EnhancementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnhancementApplication.class, args);
    }

}
