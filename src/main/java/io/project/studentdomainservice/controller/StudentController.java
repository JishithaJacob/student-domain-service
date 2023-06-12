package io.project.studentdomainservice.controller;

import io.project.studentdomainservice.model.Student;
import io.project.studentdomainservice.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

   private final StudentRepository repository;

   public  StudentController(StudentRepository repository){ /*dependancy injection*/
       this.repository=repository;

    }

    @GetMapping()
    public Iterable<Student> getStudents(){
       return repository.findAll();
    }

    @GetMapping ("/{id}")
    public Student getStudentById(@PathVariable ("id") Student student){
       return student;
    }


}
