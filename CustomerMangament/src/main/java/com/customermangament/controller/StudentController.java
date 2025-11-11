package com.customermangament.controller;

import com.customermangament.entity.Student;
import com.customermangament.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("home")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("username", "Ning");
        List<Student> students = this.studentService.getList();
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("{id}/{userId}")
    public ModelAndView showPathVariable(@PathVariable(name = "id") Long id, @PathVariable(name = "userId") Long userId) {
        ModelAndView modelAndView = new ModelAndView("showPathVariable");
        modelAndView.addObject("id", id);
        modelAndView.addObject("userId", userId);
        return modelAndView;
    }


    @GetMapping("create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("create")
    public String create(Student student, RedirectAttributes redirectAttributes) {
        this.studentService.add(student);
        redirectAttributes.addFlashAttribute("message", "Create Student Successfully");
        return "redirect:/students/home";
    }

}
