package com.mbburgos.enrollmentbackendservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbburgos.enrollmentbackendservice.generator.SubjectGenerator;
import com.mbburgos.enrollmentbackendservice.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SubjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SubjectService subjectService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReturnSubject() throws Exception {
        var subject = SubjectGenerator.generateSubjectModel();

        when(subjectService.retrieveSubject(subject.id())).thenReturn(subject);

        mvc.perform(get("/enrollment/subject/" + subject.id()).contextPath("/enrollment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(subject)));
    }

    @Test
    void shouldReturnAllStudentProfiles() throws Exception {
        var subjects = Arrays.asList(SubjectGenerator.generateSubjectModel(),
                SubjectGenerator.generateSubjectModel(),
                SubjectGenerator.generateSubjectModel());

        when(subjectService.retrieveAllSubjects()).thenReturn(subjects);

        mvc.perform(get("/enrollment/subjects/").contextPath("/enrollment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(subjects)));
    }
}
