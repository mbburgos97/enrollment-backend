package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.entity.TeacherEntity;
import com.mbburgos.enrollmentbackendservice.generator.TeacherGenerator;
import com.mbburgos.enrollmentbackendservice.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
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

        assertThat(teacher.id()).isEqualTo(teacherEntity.getTeacherId());
        assertThat(teacher.password()).isEqualTo(teacherEntity.getEncryptedPassword());
        assertThat(teacher).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(teacherEntity);
    }

    @Test
    void shouldReturnAllTeacherModels() {
        var teacherEntities = Arrays.asList(TeacherGenerator.generateTeacherEntity(),
                TeacherGenerator.generateTeacherEntity(),
                TeacherGenerator.generateTeacherEntity());

        when(teacherRepository.findAll()).thenReturn(teacherEntities);

        var teachers = teacherService.retrieveAllTeachers();

        teachers.forEach(teacher -> assertThat(teacher).usingRecursiveComparison()
                .ignoringFields("id", "password")
                .isEqualTo(teacherEntities.stream()
                        .filter(entity -> entity.getTeacherId().equals(teacher.id()))
                        .findFirst().get()));
    }

    @Test
    void shouldCreateStudentModel() {
        var teacherModel = TeacherGenerator.generateTeacherModel();
        var teacherEntity = TeacherEntity.builder()
                .teacherId(teacherModel.id())
                .nickname(teacherModel.nickname())
                .email(teacherModel.email())
                .contactNumber(teacherModel.contactNumber())
                .encryptedPassword(teacherModel.password())
                .username(teacherModel.username())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .middleName(teacherModel.middleName())
                .firstName(teacherModel.firstName())
                .lastName(teacherModel.lastName())
                .profileImage(teacherModel.profileImage())
                .build();

        when(teacherRepository.save(any())).thenReturn(teacherEntity);

        var teacher = teacherService.createTeacher(teacherModel);

        assertThat(teacher.id()).isEqualTo(teacherEntity.getTeacherId());
        assertThat(teacher.password()).isEqualTo(teacherEntity.getEncryptedPassword());
        assertThat(teacher).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(teacherEntity);
    }
}
