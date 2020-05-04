package com.MumSched.MUMSched.Controller;

import com.MumSched.MUMSched.Models.Student;
import com.MumSched.MUMSched.Repository.EntryRepository;
import com.MumSched.MUMSched.Repository.StudentRepository;
import com.MumSched.MUMSched.Services.EntBlock.EntBlockService;
import com.MumSched.MUMSched.Services.Students.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    Studentservice studentservice;
    EntryRepository entryRepository;
    EntBlockService entBlockService;
    Boolean status = false;
    int i = 0;

    @Autowired
    public StudentController(Studentservice studentservice,
                             EntryRepository entryRepository,
                             EntBlockService entBlockService) {
        this.studentservice = studentservice;
        this.entryRepository = entryRepository;
    }

    @GetMapping("/list")
    public String getStudents(Model model) {

        Student student = new Student();
        List<Student> listStudent = studentservice.findAll();
        model.addAttribute("students", listStudent);
        status = i == 1 ? true : false;
        model.addAttribute("success", status);
        model.addAttribute("student", student);
        model.addAttribute("entries", entryRepository.findAll());
        i = 0;

        return "thym/list_student";
    }

    @GetMapping("/studentDetail")
    public String getStudent(Model model) {

        model.addAttribute("students", studentservice.findAll());

        return "student_detail";
    }

    @PostMapping("/createStudent")
    public String handlePostRequest(
            @ModelAttribute("student") Student student) {

        // @Valid CustomerLicenseRegistration customerLicenseRegistration,
        //Model model
//        var s = new Student();
//        s.setName(model);
//        studentservice.saveStudent(s);
        i = 1;
        studentservice.saveStudent(student);
        return "redirect:/list";
    }



}
