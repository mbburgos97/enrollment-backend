package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.generator.TeacherGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void shouldReturnTeacherEntity() {
        var entity = TeacherGenerator.generateTeacherEntity();

        teacherRepository.save(entity);

        var retrieveEntity = teacherRepository.findById(entity.getTeacherId()).get();

        assertThat(retrieveEntity).usingRecursiveComparison().isEqualTo(retrieveEntity);
    }
}
