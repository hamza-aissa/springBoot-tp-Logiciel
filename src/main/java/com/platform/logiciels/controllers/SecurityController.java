package com.platform.logiciels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {
    @GetMapping("/accessDenied")
    public String error()
    {
        return "accessDenied";
    }
}