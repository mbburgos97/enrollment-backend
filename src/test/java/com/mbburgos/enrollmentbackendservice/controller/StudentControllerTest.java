package com.mbburgos.enrollmentbackendservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.model.Student;
import com.mbburgos.enrollmentbackendservice.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

        mvc.perform(get("/enrollment/student/" + student.studentId()).contextPath("/enrollment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(student)));
    }
}
