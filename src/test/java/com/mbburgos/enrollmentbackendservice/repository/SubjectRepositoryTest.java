package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.generator.StudentGenerator;
import com.mbburgos.enrollmentbackendservice.generator.SubjectGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

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

    @Test
    void shouldReturnAllSubjectEntities() {
        var entities = Arrays.asList(SubjectGenerator.generateSubjectEntity(),
                SubjectGenerator.generateSubjectEntity(),
                SubjectGenerator.generateSubjectEntity());

        entities.forEach(entity -> subjectRepository.save(entity));

        var retrieveEntities = subjectRepository.findAll();

        retrieveEntities.forEach(retrieveEntity -> assertThat(retrieveEntity).usingRecursiveComparison()
                .isEqualTo(entities.stream()
                        .filter(entity -> entity.getSubjectId().equals(retrieveEntity.getSubjectId()))
                        .findFirst().get()));
    }
}
