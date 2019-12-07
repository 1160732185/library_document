package com.document.ecust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/lib")
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "simpleSearch";
    }
    @RequestMapping("")
    public String index2() {
        return "simpleSearch";
    }
}

