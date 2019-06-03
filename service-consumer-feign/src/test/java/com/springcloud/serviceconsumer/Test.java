package com.springcloud.serviceconsumer;

public class Test {

    @org.junit.Test
    public void testA(){
        System.out.println("begin testA ");
        data1();
        System.out.println("end testA ");
    }

    public void data1(){
        System.out.println("begin DATA1 ");
        if (1 != 0) {
            throw new AssertionError();
        }

        System.out.println("end DATA1 ");
    }
}
