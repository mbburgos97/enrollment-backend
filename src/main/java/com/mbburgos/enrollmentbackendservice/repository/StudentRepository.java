package com.mbburgos.enrollmentbackendservice.repository;

import com.mbburgos.enrollmentbackendservice.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, String> {
}
