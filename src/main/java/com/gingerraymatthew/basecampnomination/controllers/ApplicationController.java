package com.gingerraymatthew.basecampnomination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apply")
public class ApplicationController {
    @GetMapping
    public String getApplication() {
        return "application";
    }

    @PostMapping
    public String postApplication() {
        return "application";
    }
}
