package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.generator.SubjectGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
public class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @BeforeEach
    public void setup() {
        subjectRepository.deleteAll();
    }

    @Test
    void shouldReturnSubjectEntity() {
        var entity = SubjectGenerator.generateSubjectEntity();

        subjectRepository.save(entity);

        var retrieveEntity = subjectRepository.findById(entity.getSubjectId()).get();

        assertThat(retrieveEntity).usingRecursiveComparison().isEqualTo(entity);
    }
}
