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

        assertThat(teacher.id()).isEqualTo(teacherEntity.getTeacherId());
        assertThat(teacher.password()).isEqualTo(teacherEntity.getEncryptedPassword());
        assertThat(teacher).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(teacherEntity);
    }

    @Test
    void shouldConvertTeacherModelToEntity() {
        var teacher = TeacherGenerator.generateTeacherModel();

        var teacherEntity = TeacherMapper.INSTANCE.toEntity(teacher);

        assertThat(teacher.id()).isEqualTo(teacherEntity.getTeacherId());
        assertThat(teacher.password()).isEqualTo(teacherEntity.getEncryptedPassword());
        assertThat(teacher).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(teacherEntity);
    }

    @Test
    void shouldPatchTeacherEntityAndModel() {
        var teacher = TeacherGenerator.generateTeacherModel();
        var teacherEntity = TeacherGenerator.generateTeacherEntity();

        teacherEntity.setTeacherId(teacher.id());

        var patchedStudentEntity = teacherEntity.update(teacher);

        assertThat(teacher.id()).isEqualTo(patchedStudentEntity.getTeacherId());
        assertThat(teacher.password()).isEqualTo(patchedStudentEntity.getEncryptedPassword());
        assertThat(teacher).usingRecursiveComparison().ignoringFields("id", "password").isEqualTo(patchedStudentEntity);
    }
}
