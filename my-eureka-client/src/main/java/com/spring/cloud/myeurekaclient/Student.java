package com.spring.cloud.myeurekaclient;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private String name;
    private int age;


}
