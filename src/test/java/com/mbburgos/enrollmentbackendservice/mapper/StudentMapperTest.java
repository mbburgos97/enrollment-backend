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

        var studentModel = StudentMapper.INSTANCE.toModel(studentEntity);

        assertThat(studentModel.studentId()).isEqualTo(studentEntity.getStudentId());
        assertThat(studentModel.firstName()).isEqualTo(studentEntity.getFirstName());
        assertThat(studentModel.middleName()).isEqualTo(studentEntity.getMiddleName());
        assertThat(studentModel.lastName()).isEqualTo(studentEntity.getLastName());
        assertThat(studentModel.profileImage()).isEqualTo(studentEntity.getProfileImage());
    }
}
