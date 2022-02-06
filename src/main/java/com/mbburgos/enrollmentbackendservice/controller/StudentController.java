package com.mbburgos.enrollmentbackendservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbburgos.enrollmentbackendservice.model.Student;
import com.mbburgos.enrollmentbackendservice.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public record StudentController(StudentService studentService, ObjectMapper mapper) {

    @GetMapping("/student/{id}")
    public Student retrieveStudentProfile(@PathVariable("id") String studentId) {
        return studentService.retrieveStudent(studentId);
    }

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentService.retrieveAllStudents();
    }

    @PostMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Map<String, Object> parameters) throws JsonProcessingException {
        return studentService.createStudent(mapper.readValue(mapper.writeValueAsString(parameters), Student.class));
    }
}
