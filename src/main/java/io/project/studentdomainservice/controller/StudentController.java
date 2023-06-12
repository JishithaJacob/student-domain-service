package io.project.studentdomainservice.controller;

import io.project.studentdomainservice.model.Student;
import io.project.studentdomainservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
   @Autowired
    StudentRepository repository;

    @GetMapping()
    public Iterable<Student> getStudents(){
       return repository.findAll();
    }

    @GetMapping ("/{id}")
    public Student getStudentById(@PathVariable ("id") Student student){
       return student;
    }


}
