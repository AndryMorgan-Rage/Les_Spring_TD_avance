package com.hei.student_managment.controller;

import com.hei.student_managment.exception.BadRequestException;
import com.hei.student_managment.model.Student;
import com.hei.student_managment.service.StudentService;
import com.hei.student_managment.validator.StudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final StudentService studentService;
    private final StudentValidator studentValidator;

    // Injection par constructeur
    public StudentController(StudentService studentService, StudentValidator studentValidator) {
        this.studentService = studentService;
        this.studentValidator = studentValidator;
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students) {
        try {
            // 1. On valide chaque étudiant via le Validator
            for (Student s : students) {
                studentValidator.validate(s);
            }

            studentService.addStudents(students);
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.getAllStudents());

        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
