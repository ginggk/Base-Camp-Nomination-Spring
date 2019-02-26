package com.gingerraymatthew.basecampnomination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interview")
public class InterviewController {

    @GetMapping
    public String getInterview() {
        return "interview";
    }

    @PostMapping
    public String postInterview() {
        return "interview";
    }
}
