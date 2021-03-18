package com.wei.study.java.spring.boot.starter.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class DemoConfiguration {

    private DemoProperties demoProperties;

    public DemoConfiguration(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public DemoService demoService() {
        DemoService demoService = new DemoService();
        demoService.setDemoProperties(this.demoProperties);
        return demoService;
    }

}
