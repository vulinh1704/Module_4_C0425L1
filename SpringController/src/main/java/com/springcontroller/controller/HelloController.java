package com.springcontroller.controller;

import com.springcontroller.entity.Student;
import com.springcontroller.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    public ModelAndView testHello() {
        ModelAndView modelAndView = new ModelAndView("home");
        String name = "C04";
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @GetMapping("/students/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Student> students = this.studentService.getList();
        modelAndView.addObject("students", students);
        return modelAndView;
    }

}
