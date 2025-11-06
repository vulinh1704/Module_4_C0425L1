package com.demo.service;

import com.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> list = new ArrayList<>();

    public StudentService() {
        list.add(new Student("Ning", 12));
        list.add(new Student("Trung", 22));
    }

    public List<Student> getList() {
        return this.list;
    }
}
