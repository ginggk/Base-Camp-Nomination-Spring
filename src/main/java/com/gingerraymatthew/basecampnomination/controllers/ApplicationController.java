package com.gingerraymatthew.basecampnomination.controllers;

import com.gingerraymatthew.basecampnomination.forms.StudentForm;
import com.gingerraymatthew.basecampnomination.repositories.PostgresStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gingerraymatthew.basecampnomination.repositories.Repository;

@Controller
@RequestMapping("/apply")
public class ApplicationController {
    Repository<StudentForm> studentRepository;

    @Autowired
    public ApplicationController(PostgresStudentRepository repository) {
        studentRepository = repository;
    }
    @GetMapping
    public String getApplication() {
        return "application";
    }

    @PostMapping
    public String postApplication(StudentForm student, Model model) {
        if (student.isValid() && studentRepository.check(student.getEmail())) {
            studentRepository.save(student);
            System.out.println("SUCCESS");
            return "resources";
        } else {
            System.out.println("FAILURE");
            String str = "This email is already registered (" + student.getEmail() + ")";
            model.addAttribute("text", str);
            return "application";
        }
    }
}
