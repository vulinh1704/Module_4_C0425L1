package com.springcontroller.controller;

import com.springcontroller.entity.Student;
import com.springcontroller.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("students") // => Handler Mapping
public class StudentController {
    @Autowired
    private StudentService studentService;

    // @RequestMapping(value = "home", method = RequestMethod.GET) // => students/home method GET
    @GetMapping("home")
    public ModelAndView showHome() {
//        @RequestParam("name") String nameParam
//        RequestParam sử dụng dành query param(sau ? trên URL => dành cho việc tìm kiếm)
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("name", "Ning");
//        modelAndView.addObject("nameParam", nameParam);
//        return modelAndView;

        ModelAndView modelAndView = new ModelAndView("list");
        List<Student> students = this.studentService.getList();
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    // PathVariable
    @GetMapping("{id}/{userId}") // => Sử dụng khi cần truyền id
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
    public String create(Student student) {
        this.studentService.add(student);
        return "redirect:/students/home";
    }

    // test lại 1 lượt các annotation như demo
    // CRUD student vơí array list
    // Tìm hiểu cách valìdate ở trong Spring MVC và ứng dụng.
}
