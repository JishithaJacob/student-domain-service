package io.project.studentdomainservice.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/home")
    public String home (){
        return("Welcome to home page");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminHome (){
        return("Admin: Welcome to home page");
    }
}
