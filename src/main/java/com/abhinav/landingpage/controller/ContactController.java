package com.abhinav.landingpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @PostMapping("/contact")
    public String submitForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        System.out.println("========== Contact Form ==========");
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
        System.out.println("Message : " + message);
        System.out.println("==================================");

        return "redirect:/?success=true";
    }

}