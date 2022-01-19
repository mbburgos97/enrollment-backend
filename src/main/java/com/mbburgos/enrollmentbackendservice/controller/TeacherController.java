package com.mbburgos.enrollmentbackendservice.controller;

import com.mbburgos.enrollmentbackendservice.model.Teacher;
import com.mbburgos.enrollmentbackendservice.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record TeacherController(TeacherService teacherService) {

    @GetMapping("/teacher/{id}")
    public Teacher retrieveTeacherProfile(@PathVariable("id") String teacherId) {
        return teacherService.retrieveTeacher(teacherId);
    }

    @GetMapping("/teachers")
    public void retrieveAllTeachers() {

    }
}
