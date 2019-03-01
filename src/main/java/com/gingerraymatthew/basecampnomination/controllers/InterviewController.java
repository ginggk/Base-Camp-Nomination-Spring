package com.gingerraymatthew.basecampnomination.controllers;

import com.gingerraymatthew.basecampnomination.forms.StudentForm;
import com.gingerraymatthew.basecampnomination.repositories.PostgresStudentRepository;
import com.gingerraymatthew.basecampnomination.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interview")
public class InterviewController {
    Repository<StudentForm> studentRepository;

    @Autowired
    public InterviewController(PostgresStudentRepository repository) {
        studentRepository = repository;
    }

    @GetMapping
    public String getInterview(Model model) {
        model.addAttribute("interview", studentRepository.findAll());
        return "interview";
    }

    @GetMapping("/{id}")
    public String getInterviewPage(Model model, @PathVariable(value = "id") Integer id) {
        var student = studentRepository.findById(id);
        if (student.isPresent()) {
            model.addAttribute("applicant", student.get());
            return "applicant";
        } else {
            return "404";
        }
    }

    @PostMapping
    public String postInterview() {
        return "interview";
    }

}
