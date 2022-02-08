package com.mbburgos.enrollmentbackendservice.generator;


import com.mbburgos.enrollmentbackendservice.entity.StudentEntity;
import com.mbburgos.enrollmentbackendservice.model.Student;

import java.time.LocalDateTime;

import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;

public abstract class StudentGenerator {
    public static StudentEntity generateStudentEntity() {
        return StudentEntity.builder()
                .studentId(randomAlphabeticString())
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

    public static Student generateStudentModel() {
        return new Student(randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString(),
                randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString(),
                randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString());
    }

    public static StudentEntity toEntity(Student student) {
        return StudentEntity.builder()
                .studentId(student.id())
                .nickname(student.nickname())
                .email(student.email())
                .contactNumber(student.contactNumber())
                .encryptedPassword(student.password())
                .username(student.username())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .middleName(student.middleName())
                .firstName(student.firstName())
                .lastName(student.lastName())
                .profileImage(student.profileImage())
                .build();
    }
}
