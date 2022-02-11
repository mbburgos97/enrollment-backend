package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.generator.AnnouncementGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
public class AnnouncementRepositoryTest {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @BeforeEach
    public void setup() {
        announcementRepository.deleteAll();
    }

    @Test
    void shouldCreateAnnouncementEntity() {
        var entity = AnnouncementGenerator.generateAnnouncementEntity();

        var savedEntity = announcementRepository.save(entity);

        var retrieveEntity = announcementRepository.findById(savedEntity.getId()).get();

        assertThat(savedEntity).usingRecursiveComparison().isEqualTo(retrieveEntity);
    }
}
