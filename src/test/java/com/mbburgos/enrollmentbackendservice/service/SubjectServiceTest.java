package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.generator.SubjectGenerator;
import com.mbburgos.enrollmentbackendservice.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SubjectServiceTest {

    @Autowired
    private SubjectService subjectService;

    @MockBean
    private SubjectRepository subjectRepository;

    @Test
    void shouldReturnSubjectModel() {
        var subjectEntity = SubjectGenerator.generateSubjectEntity();

        when(subjectRepository.findById(any())).thenReturn(Optional.of(subjectEntity));

        var subject = subjectService.retrieveSubject(subjectEntity.getId());

        assertThat(subject).usingRecursiveComparison().isEqualTo(subjectEntity);
    }

    @Test
    void shouldReturnAllSubjectModels() {
        var subjectEntities = Arrays.asList(SubjectGenerator.generateSubjectEntity(),
                SubjectGenerator.generateSubjectEntity(),
                SubjectGenerator.generateSubjectEntity());

        when(subjectRepository.findAll()).thenReturn(subjectEntities);

        var subjects = subjectService.retrieveAllSubjects();

        subjects.forEach(subject -> assertThat(subject).usingRecursiveComparison()
                .isEqualTo(subjectEntities.stream()
                        .filter(entity -> entity.getId().equals(subject.id()))
                        .findFirst().get()));
    }
}
