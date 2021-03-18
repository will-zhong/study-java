package com.wei.study.java.spring.boot.starter.demo.test;

import com.wei.study.java.spring.boot.starter.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@SpringBootApplication
public class TestAppliction {

    public static void main(String[] args) {
        SpringApplication.run(TestAppliction.class, args);
    }

    @Resource
    DemoService demoService;

    @Bean
    public CommandLineRunner execGoaccess() {
        return (args)-> {
            demoService.print();
            System.out.println("你好");
        };
    }
}
