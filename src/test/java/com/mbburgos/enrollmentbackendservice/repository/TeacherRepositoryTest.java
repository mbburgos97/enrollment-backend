package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.generator.TeacherGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @BeforeEach
    public void setup() {
        teacherRepository.deleteAll();
    }

    @Test
    void shouldReturnTeacherEntity() {
        var entity = TeacherGenerator.generateTeacherEntity();

        teacherRepository.save(entity);

        var retrieveEntity = teacherRepository.findById(entity.getTeacherId()).get();

        assertThat(retrieveEntity).usingRecursiveComparison().isEqualTo(retrieveEntity);
    }

    @Test
    void shouldReturnAllTeacherEntities() {
        var entities = Arrays.asList(TeacherGenerator.generateTeacherEntity(),
                TeacherGenerator.generateTeacherEntity(),
                TeacherGenerator.generateTeacherEntity());

        entities.forEach(entity -> teacherRepository.save(entity));

        var retrieveEntities = teacherRepository.findAll();

        retrieveEntities.forEach(retrieveEntity -> assertThat(retrieveEntity).usingRecursiveComparison()
                .isEqualTo(entities.stream()
                        .filter(entity -> entity.getTeacherId().equals(retrieveEntity.getTeacherId()))
                        .findFirst().get()));
    }
}
