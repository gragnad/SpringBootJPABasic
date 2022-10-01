package com.nalstudio.JPA_BASIC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("ajaxHome")
    public String ajaxHome(Model model) {
        return "ajaxHome";
    }
}
