package com.hei.student_managment.controller;

import com.hei.student_managment.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> studentList = new ArrayList<>();


    @GetMapping("/welcome")
public String welcome(@RequestParam String name){
    return "welcome"+" "+name;
    }

    @PostMapping("/students")
public String addStudent(@RequestBody List<Student> students){
        studentList.addAll(students);
        String nom = "";
        for (Student s:students){
            nom = nom + s.getFirstName()+" ";
        }
        return nom;
    }

    @GetMapping("/students")
    public String getStudents(@RequestHeader("Accept") String acceptHeader) {
        if ("text/plain".equals(acceptHeader)) {
            String students = "";
            for (Student s:studentList){
                students = students + s.getFirstName()+" ";
            }
            return students;
        }else {
            return "format non supported";
        }
    }
}
