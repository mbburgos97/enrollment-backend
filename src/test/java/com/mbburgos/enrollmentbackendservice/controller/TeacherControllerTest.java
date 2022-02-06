package com.mbburgos.enrollmentbackendservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbburgos.enrollmentbackendservice.generator.TeacherGenerator;
import com.mbburgos.enrollmentbackendservice.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TeacherService teacherService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReturnTeacherProfile() throws Exception {
        var teacher = TeacherGenerator.generateTeacherModel();

        when(teacherService.retrieveTeacher(any())).thenReturn(teacher);

        mvc.perform(get("/enrollment/teacher/" + teacher.id()).contextPath("/enrollment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(teacher)));
    }

    @Test
    void shouldReturnAllTeacherProfiles() throws Exception {
        var teachers = Arrays.asList(TeacherGenerator.generateTeacherModel(),
                TeacherGenerator.generateTeacherModel(),
                TeacherGenerator.generateTeacherModel());

        when(teacherService.retrieveAllTeachers()).thenReturn(teachers);

        mvc.perform(get("/enrollment/teachers").contextPath("/enrollment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(teachers)));
    }

    @Test
    void shouldCreateTeacherProfile() throws Exception {
        var teacher = TeacherGenerator.generateTeacherModel();

        when(teacherService.createTeacher(any())).thenReturn(teacher);

        mvc.perform(post("/enrollment/teacher/").contextPath("/enrollment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teacher)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(teacher)));
    }
}
