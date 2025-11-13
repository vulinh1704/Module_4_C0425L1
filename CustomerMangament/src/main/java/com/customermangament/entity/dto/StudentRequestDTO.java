package com.customermangament.entity.dto;

import org.springframework.web.multipart.MultipartFile;

public class StudentRequestDTO {
    private String name;
    private int age;
    private MultipartFile image;

    public StudentRequestDTO() {
    }

    public StudentRequestDTO(String name, int age, MultipartFile image) {
        this.name = name;
        this.age = age;
        this.image = image;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
