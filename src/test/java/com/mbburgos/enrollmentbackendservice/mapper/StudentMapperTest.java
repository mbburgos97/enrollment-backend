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

        assertThat(student.studentId()).isEqualTo(studentEntity.getStudentId());
        assertThat(student.firstName()).isEqualTo(studentEntity.getFirstName());
        assertThat(student.middleName()).isEqualTo(studentEntity.getMiddleName());
        assertThat(student.lastName()).isEqualTo(studentEntity.getLastName());
        assertThat(student.profileImage()).isEqualTo(studentEntity.getProfileImage());

        assertThat(student.username()).isEqualTo(studentEntity.getUsername());
        assertThat(student.email()).isEqualTo(studentEntity.getEmail());
        assertThat(student.contactNumber()).isEqualTo(studentEntity.getContactNumber());
        assertThat(student.nickname()).isEqualTo(studentEntity.getNickname());
    }
}
