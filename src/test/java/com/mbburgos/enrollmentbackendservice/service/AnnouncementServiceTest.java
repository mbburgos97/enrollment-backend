package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.generator.AnnouncementGenerator;
import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.generator.SubjectGenerator;
import com.mbburgos.enrollmentbackendservice.generator.TeacherGenerator;
import com.mbburgos.enrollmentbackendservice.repository.AnnouncementRepository;
import com.mbburgos.enrollmentbackendservice.repository.StudentRepository;
import com.mbburgos.enrollmentbackendservice.repository.SubjectRepository;
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
public class AnnouncementServiceTest {

    @Autowired
    private AnnouncementService announcementService;

    @MockBean
    private AnnouncementRepository announcementRepository;

    @MockBean
    private SubjectRepository subjectRepository;

    @MockBean
    private TeacherRepository teacherRepository;

    @Test
    void shouldCreateAnnouncementModel() {
        var announcementRequest = AnnouncementGenerator.generateAnnounceRequest();

        var announcementEntity = AnnouncementGenerator.requestToEntity(announcementRequest);
        var subjectEntity = SubjectGenerator.generateSubjectEntity();
        var teacherEntity = TeacherGenerator.generateTeacherEntity();

        when(announcementRepository.save(any())).thenReturn(announcementEntity);
        when(teacherRepository.findById(any())).thenReturn(Optional.of(teacherEntity));
        when(subjectRepository.findById(any())).thenReturn(Optional.of(subjectEntity));

        var announcement = announcementService.createAnnouncement(announcementRequest);

        assertThat(announcement.teacherName()).isEqualTo(teacherEntity.getLastName());
        assertThat(announcement.subject()).isEqualTo(subjectEntity.getTitle());
        assertThat(announcement).usingRecursiveComparison().ignoringFields("teacherName", "subject").isEqualTo(announcementEntity);
    }
}
