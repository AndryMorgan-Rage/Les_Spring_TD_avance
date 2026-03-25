package com.hei.student_managment.validator;

import com.hei.student_managment.exception.BadRequestException;
import com.hei.student_managment.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentValidator {
    public void validate(Student student) {
        if (student.getReference() == null || student.getReference().isEmpty() ||
                student.getFirstName() == null || student.getFirstName().isEmpty() ||
                student.getLastName() == null || student.getLastName().isEmpty()) {
            throw new BadRequestException("les reference vide avec les non vide return un probleme");
        }
    }
}
