package com.mbburgos.enrollmentbackendservice.generator;

import com.mbburgos.enrollmentbackendservice.entity.SubjectEntity;
import com.mbburgos.enrollmentbackendservice.model.Subject;

import java.time.LocalDateTime;

import static com.tyro.oss.randomdata.RandomLong.randomLong;
import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;

public abstract class SubjectGenerator {
    public static SubjectEntity generateSubjectEntity() {
        return SubjectEntity.builder()
                .id(randomLong())
                .teacherId(randomAlphabeticString())
                .title(randomAlphabeticString())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Subject generateSubjectModel() {
        return new Subject(randomLong(), randomAlphabeticString(), randomAlphabeticString());
    }
}
