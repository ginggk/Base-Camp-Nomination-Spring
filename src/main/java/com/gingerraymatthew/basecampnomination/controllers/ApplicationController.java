package com.gingerraymatthew.basecampnomination.controllers;

import com.gingerraymatthew.basecampnomination.forms.StudentForm;
import com.gingerraymatthew.basecampnomination.repositories.PostgresStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String postApplication(StudentForm student) {
        if (student.isValid()) {
            studentRepository.save(student);
            System.out.println("SUCCESS");
            return "landing";
        } else {
            System.out.println("FAILURE");
            return "application";
        }
    }
}
