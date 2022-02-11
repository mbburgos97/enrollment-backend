package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

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

        assertThat(student.id()).isEqualTo(studentEntity.getStudentId());
        assertThat(student.password()).isEqualTo(studentEntity.getEncryptedPassword());
        assertThat(student).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(studentEntity);
    }

    @Test
    void shouldReturnAllStudentModels() {
        var studentEntities = Arrays.asList(StudentGenerator.generateStudentEntity(),
                StudentGenerator.generateStudentEntity(),
                StudentGenerator.generateStudentEntity());

        when(studentRepository.findAll()).thenReturn(studentEntities);

        var students = studentService.retrieveAllStudents();

        students.forEach(student -> assertThat(student).usingRecursiveComparison()
                .ignoringFields("id", "password")
                .isEqualTo(studentEntities.stream()
                        .filter(entity -> entity.getStudentId().equals(student.id()))
                        .findFirst().get()));
    }

    @Test
    void shouldCreateStudentModel() {
        var studentModel = StudentGenerator.generateStudentModel();
        var studentEntity = StudentGenerator.toEntity(studentModel);

        when(studentRepository.save(any())).thenReturn(studentEntity);

        var student = studentService.createStudent(studentModel);

        assertThat(student.id()).isEqualTo(studentEntity.getStudentId());
        assertThat(student.password()).isEqualTo(studentEntity.getEncryptedPassword());
        assertThat(student).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(studentEntity);
    }

    @Test
    void shouldPatchStudentModel() {
        var studentModel = StudentGenerator.generateStudentModel();
        var studentEntity = StudentGenerator.generateStudentEntity();
        studentEntity.setStudentId(studentModel.id());

        when(studentRepository.findById(any())).thenReturn(Optional.of(studentEntity));
        when(studentRepository.save(any())).thenReturn(studentEntity.update(studentModel));

        var student = studentService.patchStudent(studentModel.id(), studentModel);

        assertThat(student.id()).isEqualTo(studentEntity.getStudentId());
        assertThat(student).usingRecursiveComparison().isEqualTo(studentModel);
    }
}
