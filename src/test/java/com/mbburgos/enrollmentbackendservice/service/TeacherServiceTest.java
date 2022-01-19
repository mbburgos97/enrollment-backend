package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.generator.TeacherGenerator;
import com.mbburgos.enrollmentbackendservice.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @MockBean
    private TeacherRepository teacherRepository;

    @Test
    void shouldReturnTeacherModel() {
        var teacherEntity = TeacherGenerator.generateTeacherEntity();

        when(teacherRepository.findById(any())).thenReturn(Optional.of(teacherEntity));

        var teacher = teacherService.retrieveTeacher(teacherEntity.getTeacherId());

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
