package io.project.studentdomainservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*Spring Boot 3.0 will be the first version of Spring Boot
that makes use of Jakarta EE 9 APIs (jakarta.) instead of EE 8 (javax.)*/
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;
    private int enabled;

    public Student() {}

    public Student(String username, String password, String role, int enabled){
        this.id=id;
        this.username=username;
        this.password=password;
        this.role=role;
        this.enabled=enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}





