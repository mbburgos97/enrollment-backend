package com.mbburgos.enrollmentbackendservice.generator;

import com.mbburgos.enrollmentbackendservice.entity.AnnouncementEntity;
import com.mbburgos.enrollmentbackendservice.entity.StudentEntity;
import com.mbburgos.enrollmentbackendservice.model.Announcement;
import com.mbburgos.enrollmentbackendservice.model.Student;
import com.mbburgos.enrollmentbackendservice.model.request.AnnouncementRequest;

import java.time.LocalDateTime;

import static com.tyro.oss.randomdata.RandomLong.randomLong;
import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;

public abstract class AnnouncementGenerator {
    public static AnnouncementEntity generateAnnouncementEntity() {
        return AnnouncementEntity.builder()
                .content(randomAlphabeticString())
                .title(randomAlphabeticString())
                .subjectId(randomLong())
                .teacherId(randomAlphabeticString())
                .id(randomLong())
                .build();
    }

    public static Announcement generateAnnouncementModel() {
        return new Announcement(randomLong(), randomAlphabeticString(),
                randomAlphabeticString(), randomAlphabeticString(), randomAlphabeticString());
    }

    public static AnnouncementRequest generateAnnounceRequest() {
        return new AnnouncementRequest(randomAlphabeticString(), randomLong(),
                randomAlphabeticString(), randomAlphabeticString());
    }

    public static AnnouncementEntity requestToEntity(AnnouncementRequest request) {
        return AnnouncementEntity.builder()
                .id(randomLong())
                .teacherId(request.teacherId())
                .title(request.title())
                .content(request.content())
                .subjectId(request.subjectId())
                .build();
    }

}
