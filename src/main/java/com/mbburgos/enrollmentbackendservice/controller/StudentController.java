package com.mbburgos.enrollmentbackendservice.controller;

import com.mbburgos.enrollmentbackendservice.model.Student;
import com.mbburgos.enrollmentbackendservice.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public record StudentController(StudentService studentService) {

    @GetMapping("/student/{id}")
    public Student retrieveStudentProfile(@PathVariable("id") String studentId) {
        return studentService.retrieveStudent(studentId);
    }

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentService.retrieveAllStudents();
    }
}
