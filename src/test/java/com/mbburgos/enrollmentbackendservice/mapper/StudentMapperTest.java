package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentMapperTest {

    @Test
    void shouldConvertStudentEntityToModel() {
        var studentEntity = StudentGenerator.generateStudentEntity();

        var student = StudentMapper.INSTANCE.toModel(studentEntity);

        assertThat(student.id()).isEqualTo(studentEntity.getStudentId());
        assertThat(student.password()).isEqualTo(studentEntity.getEncryptedPassword());
        assertThat(student).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(studentEntity);
    }

    @Test
    void shouldConvertStudentModelToEntity() {
        var student = StudentGenerator.generateStudentModel();

        var studentEntity = StudentMapper.INSTANCE.toEntity(student);

        assertThat(student.id()).isEqualTo(studentEntity.getStudentId());
        assertThat(student.password()).isEqualTo(studentEntity.getEncryptedPassword());
        assertThat(student).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(studentEntity);
    }
}
