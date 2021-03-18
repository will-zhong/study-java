package com.wei.study.java.algorithm.test;

class B extends Object
{
    static
    {
        System.out.println("Load B");
    }
    public B()
    {
        System.out.println("Create B");
    }
}
class A extends B
{
    static
    {
        System.out.println("Load A");
    }
    public A()
    {
        System.out.println("Create A");
    }
}

public class Testclass
{
    public static void main(String[] args)
    {
        new A();
    }
}
