package com.example.managerstudent.controller;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.entities.StudentEntity;
import com.example.managerstudent.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student")
public class HomeController {
    @Autowired
    IStudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/list")
    public String listStudent(Model model) {
        List<StudentDTO> listStudents = studentService.getListStudents(0, 3);
        listStudents.stream().forEach(e -> System.out.println(e.toString()));
        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(Model model, StudentDTO student) {
        StudentDTO studentDTO = studentService.saveStudent(student);
        System.out.println(studentDTO);
        return "index";
    }

    @PutMapping("/update")
    public String updateStudent(Model model, StudentDTO student) {
        StudentDTO studentDTO = studentService.saveStudent(student);
        System.out.println(studentDTO);
        return "index";
    }
    @DeleteMapping("/delete")
    public String deleteStudent(Model model, StudentDTO student) {
        StudentDTO studentDTO = studentService.saveStudent(student);
        System.out.println(studentDTO);
        return "index";
    }
}
