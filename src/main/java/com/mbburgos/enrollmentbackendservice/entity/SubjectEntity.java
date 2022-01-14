package com.mbburgos.enrollmentbackendservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "subject")
public class SubjectEntity {
    @Id
    private Long subjectId;
    private String teacherId;
}
