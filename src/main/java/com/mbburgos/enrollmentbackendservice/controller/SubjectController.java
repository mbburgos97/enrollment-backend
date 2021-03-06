package com.mbburgos.enrollmentbackendservice.controller;

import com.mbburgos.enrollmentbackendservice.model.Subject;
import com.mbburgos.enrollmentbackendservice.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public record SubjectController(SubjectService subjectService) {

    @GetMapping("/subject/{id}")
    public Subject retrieveSubject(@PathVariable("id") Long id) {
        return subjectService.retrieveSubject(id);
    }

    @GetMapping("/subjects")
    public List<Subject> retrieveAllSubjects() {
        return subjectService.retrieveAllSubjects();
    }
}
