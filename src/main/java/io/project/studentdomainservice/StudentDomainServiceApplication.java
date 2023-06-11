package io.project.studentdomainservice;

import io.project.studentdomainservice.model.Student;
import io.project.studentdomainservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentDomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDomainServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository students, PasswordEncoder encoder) {
		return args -> {
			students.save(new Student("Ann",encoder.encode("passord"),"USER",1));
			students.save(new Student("Mary",encoder.encode("passord"),"USER",1));
		};
	}

}
