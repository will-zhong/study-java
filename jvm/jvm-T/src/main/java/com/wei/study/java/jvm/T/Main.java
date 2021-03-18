package com.wei.study.java.jvm.T;

public class Main {

    public static void main(String[] args) {
        Base<User> userBase = new UserBase();
        User user = userBase.getT();
        System.out.println(user);
    }
}
