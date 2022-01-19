package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.generator.TeacherGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TeacherMapperTest {

    @Test
    void shouldConvertTeacherEntityToModel() {
        var teacherEntity = TeacherGenerator.generateTeacherEntity();

        var teacher = TeacherMapper.INSTANCE.toModel(teacherEntity);

        assertThat(teacher.teacherId()).isEqualTo(teacherEntity.getTeacherId());
        assertThat(teacher.firstName()).isEqualTo(teacherEntity.getFirstName());
        assertThat(teacher.middleName()).isEqualTo(teacherEntity.getMiddleName());
        assertThat(teacher.lastName()).isEqualTo(teacherEntity.getLastName());
        assertThat(teacher.profileImage()).isEqualTo(teacherEntity.getProfileImage());

        assertThat(teacher.username()).isEqualTo(teacherEntity.getUsername());
        assertThat(teacher.email()).isEqualTo(teacherEntity.getEmail());
        assertThat(teacher.contactNumber()).isEqualTo(teacherEntity.getContactNumber());
        assertThat(teacher.nickname()).isEqualTo(teacherEntity.getNickname());
    }
}
