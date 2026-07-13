package com.Tushar.demo;

public class student {
    private String name;
    private int age;

    public student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public student(int age, String name) {
        this.age = age;
        this.name = name;


    }
}

