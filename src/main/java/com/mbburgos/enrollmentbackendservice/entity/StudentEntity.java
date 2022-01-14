package com.mbburgos.enrollmentbackendservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "student")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    private String studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String profileImage;
}
