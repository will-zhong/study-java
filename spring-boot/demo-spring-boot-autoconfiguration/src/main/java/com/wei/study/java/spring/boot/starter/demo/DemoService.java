package com.wei.study.java.spring.boot.starter.demo;

public class DemoService {

    private DemoProperties demoProperties;

    public void setDemoProperties(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    public void print() {
        System.out.println(demoProperties.toString());
    }
}
