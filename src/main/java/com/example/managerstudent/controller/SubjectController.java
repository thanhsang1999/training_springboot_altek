package com.example.managerstudent.controller;

import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.dto.SubjectDTO;
import com.example.managerstudent.entities.SubjectEntity;
import com.example.managerstudent.service.IStudentService;
import com.example.managerstudent.service.ISubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/student/"+subjectDTO.getIdStudent();
    }
    @GetMapping("/update/{id}")
    public String updateSubject(Model model, @PathVariable Long id){
        SubjectDTO dto = subjectService.findById(id);
        model.addAttribute("subject",dto);
        return "create-subject";

    }
    @GetMapping("/delete/{id}")
    public String deleteSubject(Model model,@PathVariable Long id){
        SubjectDTO dto = subjectService.findById(id);
        subjectService.deleteById(id);
        return "redirect:/student/"+dto.getIdStudent();
    }

}
