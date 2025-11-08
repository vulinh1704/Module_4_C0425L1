package com.demo.controller;

import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentController {
    @Autowired
    private StudentService studentService;
}
