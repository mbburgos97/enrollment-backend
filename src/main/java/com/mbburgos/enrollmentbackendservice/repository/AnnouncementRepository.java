package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.entity.AnnouncementEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepository extends CrudRepository<AnnouncementEntity, Long> {
}
