package com.mbburgos.enrollmentbackendservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "subject")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SubjectEntity {
    @Id
    private Long subjectId;
    private String teacherId;
    private String title;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updatedAt = null;
}
