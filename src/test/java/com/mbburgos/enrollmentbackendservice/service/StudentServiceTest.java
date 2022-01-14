package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.entity.StudentEntity;
import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    void shouldReturnStudentModel() {
        var studentEntity = StudentGenerator.generateStudentEntity();

        when(studentRepository.findById(any())).thenReturn(Optional.of(studentEntity));

        var student = studentService.retrieveStudent(studentEntity.getStudentId());

        assertThat(student.studentId()).isEqualTo(studentEntity.getStudentId());
        assertThat(student.firstName()).isEqualTo(studentEntity.getFirstName());
        assertThat(student.middleName()).isEqualTo(studentEntity.getMiddleName());
        assertThat(student.lastName()).isEqualTo(studentEntity.getLastName());
        assertThat(student.profileImage()).isEqualTo(studentEntity.getProfileImage());
    }

}
