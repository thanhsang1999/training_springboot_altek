package com.example.managerstudent.controller;

import com.example.managerstudent.dto.ListStudentWithPagi;
import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.dto.SubjectDTO;
import com.example.managerstudent.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("student")
public class HomeController {
    @Autowired
    IStudentService studentService;

    @GetMapping("")
    public String home(Model model) {
        System.out.println("LocaleContextHolder.getLocale() = " + LocaleContextHolder.getLocale());
        return "index";
    }

    @GetMapping("/list")
    public String listStudent(Model model,
                              @RequestParam(required = false,defaultValue = "0") int page,
                              @RequestParam(required = false,defaultValue = "3") int size,
                              @RequestParam(required = false,defaultValue = "") String search,
                              @RequestParam(required = false,defaultValue = "id") String column,
                              @RequestParam(required = false,defaultValue = "asc") String order) {
        ListStudentWithPagi lswp = studentService.getListStudents(page, size, search, column, order);
        model.addAttribute("lswp", lswp);
        System.out.println("lswp = " + lswp);
        return "list";
    }

    @GetMapping("/save")
    public String createPage(Model model,StudentDTO studentDTO) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "create";
    }

    @PostMapping("/save")
    public String saveStudent(StudentDTO studentDTO,Model model) {
        //todo write handle check data dto
        StudentDTO sDTO = studentService.saveStudent(studentDTO);
        System.out.println(sDTO);
        return "index";
    }



    @GetMapping("/{id}")
    public String getStudentById(Model mode, @PathVariable Long id) {
        StudentDTO dto = studentService.getStudentDTO(id);
        mode.addAttribute("student", dto);
        return "view";
    }

    @GetMapping("/{id}/subject/add")
    public String viewFormAddSubject(Model model, @PathVariable Long id) {
        SubjectDTO dto = new SubjectDTO();
        dto.setIdStudent(id);
        model.addAttribute("subject",dto);
        return "create-subject";
    }
    @GetMapping("/{idStudent}/subject/{id}")
    public String viewFormUpdateSubject(Model model, @PathVariable Long idStudent,@PathVariable Long id) {
        SubjectDTO dto = new SubjectDTO();
        dto.setIdStudent(idStudent);
        dto.setIdStudent(id);
        model.addAttribute("subject",dto);
        return "create-subject";
    }
    @GetMapping("/update/{id}")
    public String updateStudent(Model model,@PathVariable Long id) {
        StudentDTO dto = studentService.getStudentDTO(id);
        model.addAttribute("studentDTO",dto);
        return "create";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(Model model,@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/student/list";
    }
    @GetMapping("/search")
    public String searchName(Model model,@RequestParam String search){
        return "";
    }
}
