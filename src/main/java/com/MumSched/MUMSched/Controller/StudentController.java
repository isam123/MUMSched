package com.MumSched.MUMSched.Controller;

import com.MumSched.MUMSched.Models.Student;
import com.MumSched.MUMSched.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Controller
public class StudentController {


    long i = 7759;
    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/list")
    public String getStudents(Model model) {

        model.addAttribute("students", studentRepository.findAll());


        return "list_student";
    }


    @GetMapping("/studentDetail")
    public String getStudent(Model model) {

        model.addAttribute("students", studentRepository.findAll());

        return "student_detail";
    }


}
