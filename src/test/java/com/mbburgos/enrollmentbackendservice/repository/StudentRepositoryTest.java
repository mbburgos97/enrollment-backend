package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void shouldReturnStudentEntity() {
        var entity = StudentEntity.builder()
                .studentId(randomAlphabeticString())
                .profileImage(randomAlphabeticString())
                .lastName(randomAlphabeticString())
                .firstName(randomAlphabeticString())
                .middleName(randomAlphabeticString())
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();
        studentRepository.save(entity);

        var retrieveEntity = studentRepository.findById(entity.getStudentId()).get();

        assertThat(retrieveEntity).usingRecursiveComparison().isEqualTo(retrieveEntity);
    }
}
