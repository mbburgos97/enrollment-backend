package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.generator.SubjectGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SubjectMapperTest {

    @Test
    void shouldConvertSubjectEntityToModel() {
        var subjectEntity = SubjectGenerator.generateSubjectEntity();

        var subject = SubjectMapper.INSTANCE.toModel(subjectEntity);

        assertThat(subject).usingRecursiveComparison().isEqualTo(subjectEntity);
    }

    @Test
    void shouldConvertSubjectModelToEntity() {
        var subject = SubjectGenerator.generateSubjectModel();

        var subjectEntity = SubjectMapper.INSTANCE.toEntity(subject);

        assertThat(subject).usingRecursiveComparison().isEqualTo(subjectEntity);
    }
}
