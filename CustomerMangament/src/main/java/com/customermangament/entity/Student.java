package com.customermangament.entity;

public class Student {
    private String name;
    private int age;
    private String imagePath;

    public Student(String name, int age, String imagePath) {
        this.name = name;
        this.age = age;
        this.imagePath = imagePath;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
