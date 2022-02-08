package com.mbburgos.enrollmentbackendservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbburgos.enrollmentbackendservice.model.Student;
import com.mbburgos.enrollmentbackendservice.model.Teacher;
import com.mbburgos.enrollmentbackendservice.service.TeacherService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public record TeacherController(TeacherService teacherService, ObjectMapper mapper) {

    @GetMapping("/teacher/{id}")
    public Teacher retrieveTeacherProfile(@PathVariable("id") String teacherId) {
        return teacherService.retrieveTeacher(teacherId);
    }

    @GetMapping("/teachers")
    public List<Teacher> retrieveAllTeachers() {
        return teacherService.retrieveAllTeachers();
    }

    @PostMapping("/teacher")
    public Teacher createStudent(@RequestBody Map<String, Object> parameters) throws JsonProcessingException {
        return teacherService.createTeacher(mapper.readValue(mapper.writeValueAsString(parameters), Teacher.class));
    }

    @PatchMapping(value = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Teacher patchTeacher(@PathVariable("id") String id, @RequestBody Map<String, Object> parameters) throws JsonProcessingException {
        return teacherService.patchTeacher(id, mapper.readValue(mapper.writeValueAsString(parameters), Teacher.class));
    }
}
