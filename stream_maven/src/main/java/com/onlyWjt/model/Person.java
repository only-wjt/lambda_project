package com.onlyWjt.model;

public class Person {
    private int height;
    private int weight;
    private int age;
    private String gender;

    public Person height(int h) {
        this.height = h;
        return this;
    }

    public Person weight(int w) {
        this.weight = w;
        return this;
    }

    public Person age(int a) {
        this.age = a;
        return this;
    }

    public Person gender(String g) {
        this.gender = g;
        return this;
    }

    public PersonFilter filterWeight() {
        return new PersonFilter(this);
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

