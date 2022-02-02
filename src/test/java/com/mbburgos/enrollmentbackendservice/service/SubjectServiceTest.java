package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.generator.SubjectGenerator;
import com.mbburgos.enrollmentbackendservice.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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

        var subject = subjectService.retrieveSubject(subjectEntity.getSubjectId());

        assertThat(subject).usingRecursiveComparison().isEqualTo(subjectEntity);
    }
}
