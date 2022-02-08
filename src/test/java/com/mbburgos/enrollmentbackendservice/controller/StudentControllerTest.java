package com.mbburgos.enrollmentbackendservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.service.StudentService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReturnStudentProfile() throws Exception {
        var student = StudentGenerator.generateStudentModel();

        when(studentService.retrieveStudent(any())).thenReturn(student);

        mvc.perform(get("/enrollment/student/" + student.id()).contextPath("/enrollment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(student)));
    }

    @Test
    void shouldReturnAllStudentProfiles() throws Exception {
        var students = Arrays.asList(StudentGenerator.generateStudentModel(),
                StudentGenerator.generateStudentModel(),
                StudentGenerator.generateStudentModel());

        when(studentService.retrieveAllStudents()).thenReturn(students);

        mvc.perform(get("/enrollment/students/").contextPath("/enrollment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(students)));
    }

    @Test
    void shouldCreateStudentProfile() throws Exception {
        var student = StudentGenerator.generateStudentModel();

        when(studentService.createStudent(any())).thenReturn(student);

        mvc.perform(post("/enrollment/student/").contextPath("/enrollment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(student)));
    }

    @Test
    void shouldPatchStudentProfile() throws Exception {
        var student = StudentGenerator.generateStudentModel();

        when(studentService.patchStudent(any(), any())).thenReturn(student);

        mvc.perform(patch("/enrollment/student/" + student.id()).contextPath("/enrollment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(student)));
    }
}
