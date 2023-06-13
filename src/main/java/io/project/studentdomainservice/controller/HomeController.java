package io.project.studentdomainservice.controller;

import io.project.studentdomainservice.model.Student;
import io.project.studentdomainservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    StudentRepository repository;
    @GetMapping()
    public String home() {
        return "Hello, World!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user() {
        return "Hello, User!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Hello, Admin!";
    }

    @GetMapping("/newadmin")
    public String newAdmin() {
        return "Hello,NEW Admin!";
    }

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Map<String,String> body){
        String name= body.get("name");
        String password = body.get("password");
        String role = body.get("role");
        int enabled = Integer.parseInt(body.get("enabled"));
        return repository.save(new Student(name,password,role,enabled));
    }

}
