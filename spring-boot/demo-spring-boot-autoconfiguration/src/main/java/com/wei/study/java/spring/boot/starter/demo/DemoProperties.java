package com.wei.study.java.spring.boot.starter.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    private String name;

    private Integer age;
}
