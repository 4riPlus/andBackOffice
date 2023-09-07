package com.sparta.andbackoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/admin/view")
public class ViewController {
    @GetMapping("/main")
    public String mainPage() {
        return "index";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
