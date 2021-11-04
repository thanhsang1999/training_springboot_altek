package com.example.managerstudent.controller;

import com.example.managerstudent.dto.SubjectDTO;
import com.example.managerstudent.entities.SubjectEntity;
import com.example.managerstudent.service.ISubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    ISubjectService subjectService;

    @GetMapping("/")
    public String getListSubject(Model model){
        List<SubjectDTO> dtos = subjectService.findAll();
        System.out.println("dtos = " + dtos);
        return "index";
    }
    @PostMapping("/save")
    public String save(Model model,SubjectDTO subjectDTO){
        SubjectDTO dto = subjectService.save(subjectDTO);
        System.out.println("dto = " + dto);
        return "index";
    }
}
