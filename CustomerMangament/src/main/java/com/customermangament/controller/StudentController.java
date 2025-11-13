package com.customermangament.controller;

import com.customermangament.entity.Student;
import com.customermangament.entity.dto.StudentRequestDTO;
import com.customermangament.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Value("${file-upload}")
    private String fileUpload;

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
        modelAndView.addObject("student", new StudentRequestDTO());
        return modelAndView;
    }

    @PostMapping("create")
    public String create(StudentRequestDTO studentRequestDTO, RedirectAttributes redirectAttributes) throws IOException {
        MultipartFile multipartFile = studentRequestDTO.getImage();
        String fileName = multipartFile.getOriginalFilename();
        FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        Student student = new Student(studentRequestDTO.getName(), studentRequestDTO.getAge(), "/static/" + fileName);
        this.studentService.add(student);
        redirectAttributes.addFlashAttribute("message", "Create Student Successfully");
        return "redirect:/students/home";
    }

}
