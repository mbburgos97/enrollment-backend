package com.mbburgos.enrollmentbackendservice.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "teacher")
@Getter
public class TeacherEntity {

    @Id
    private String teacherId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String profileImage;
    private String username;
    private String encryptedPassword;
    private String email;
    private String contactNumber;
    private String nickname;
}
