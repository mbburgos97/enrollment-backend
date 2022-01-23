package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void shouldReturnStudentEntity() {
        var entity = StudentGenerator.generateStudentEntity();

        studentRepository.save(entity);

        var retrieveEntity = studentRepository.findById(entity.getStudentId()).get();

        assertThat(retrieveEntity).usingRecursiveComparison().isEqualTo(entity);
    }

    @Test
    void shouldReturnAllStudentEntities() {
        var entities = Arrays.asList(StudentGenerator.generateStudentEntity(),
                StudentGenerator.generateStudentEntity(),
                StudentGenerator.generateStudentEntity());

        entities.forEach(entity -> studentRepository.save(entity));

        var retrieveEntities = studentRepository.findAll();

        retrieveEntities.forEach(retrieveEntity -> assertThat(retrieveEntity).usingRecursiveComparison()
                .isEqualTo(entities.stream()
                        .filter(entity -> entity.getStudentId().equals(retrieveEntity.getStudentId()))
                        .findFirst().get()));
    }
}
