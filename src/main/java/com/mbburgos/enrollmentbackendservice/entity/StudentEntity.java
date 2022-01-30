package com.mbburgos.enrollmentbackendservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updatedAt = null;
    private String profileImage;
    private String username;
    @Column(name = "password")
    private String encryptedPassword;
    private String email;
    private String contactNumber;
    private String nickname;
}
