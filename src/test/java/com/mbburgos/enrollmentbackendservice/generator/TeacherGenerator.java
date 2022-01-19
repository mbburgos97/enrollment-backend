package com.mbburgos.enrollmentbackendservice.generator;

import com.mbburgos.enrollmentbackendservice.entity.TeacherEntity;
import com.mbburgos.enrollmentbackendservice.model.Teacher;

import java.time.LocalDateTime;

import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;

public abstract class TeacherGenerator {
    public static TeacherEntity generateTeacherEntity() {
        return TeacherEntity.builder()
                .teacherId(randomAlphabeticString())
                .profileImage(randomAlphabeticString())
                .lastName(randomAlphabeticString())
                .firstName(randomAlphabeticString())
                .middleName(randomAlphabeticString())
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .username(randomAlphabeticString())
                .encryptedPassword(randomAlphabeticString())
                .contactNumber(randomAlphabeticString())
                .nickname(randomAlphabeticString())
                .email(randomAlphabeticString())
                .build();
    }

    public static Teacher generateTeacherModel() {
        return new Teacher(randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString(),
                randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString(),
                randomAlphabeticString(), randomAlphabeticString());
    }
}
