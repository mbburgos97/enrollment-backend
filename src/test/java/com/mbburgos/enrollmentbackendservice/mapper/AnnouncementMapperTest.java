package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.generator.AnnouncementGenerator;
import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnnouncementMapperTest {

    @Test
    void shouldConvertAnnouncementEntityToModel() {
        var announcementEntity = AnnouncementGenerator.generateAnnouncementEntity();
        var teacherName = randomAlphabeticString();
        var subject = randomAlphabeticString();
        var announcement = AnnouncementMapper.INSTANCE.toModel(announcementEntity, teacherName, subject);

        assertThat(announcement.subject()).isEqualTo(subject);
        assertThat(announcement.teacherName()).isEqualTo(teacherName);
        assertThat(announcement).usingRecursiveComparison().ignoringFields("teacherName", "subject").isEqualTo(announcementEntity);
    }

    @Test
    void shouldConvertAnnouncementRequestToEntity() {
        var announcementRequest = AnnouncementGenerator.generateAnnounceRequest();
        var announcementEntity = AnnouncementMapper.INSTANCE.requestToEntity(announcementRequest);

        assertThat(announcementRequest).usingRecursiveComparison().ignoringFields("id").isEqualTo(announcementEntity);
    }
}
