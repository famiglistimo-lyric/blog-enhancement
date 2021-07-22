package com.yi.enhancement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class EnhancementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnhancementApplication.class, args);
    }

}
