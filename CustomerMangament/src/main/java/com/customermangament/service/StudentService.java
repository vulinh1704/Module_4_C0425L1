package com.customermangament.service;

import com.customermangament.entity.Student;

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

    public void add(Student student) {
        this.list.add(student);
    }
}
