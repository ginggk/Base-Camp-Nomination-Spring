package com.gingerraymatthew.basecampnomination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourcesController {
    @RequestMapping
    @GetMapping("/resources")
    public String getResources(){
        return "resources";
    }
}
