package com.hei.student_managment.service;

import com.hei.student_managment.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    private List<Student> studentList = new ArrayList<>();
    public List<Student> getAllStudents() {
        return studentList;
    }
    public void addStudents(List<Student> students) {
        studentList.addAll(students);
    }
}
