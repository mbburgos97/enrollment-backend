package com.mbburgos.enrollmentbackendservice.entity;

import com.mbburgos.enrollmentbackendservice.model.Student;
import com.mbburgos.enrollmentbackendservice.model.Teacher;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity(name = "teacher")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {

    @Id
    private String teacherId;
    private String firstName;
    private String middleName;
    private String lastName;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String profileImage;
    private String username;
    @Column(name = "password")
    private String encryptedPassword;
    private String email;
    private String contactNumber;
    private String nickname;

    public TeacherEntity update(Teacher teacher) {
        Optional.ofNullable(teacher.firstName()).ifPresent(this::setFirstName);
        Optional.ofNullable(teacher.middleName()).ifPresent(this::setMiddleName);
        Optional.ofNullable(teacher.lastName()).ifPresent(this::setLastName);
        Optional.ofNullable(teacher.username()).ifPresent(this::setUsername);
        Optional.ofNullable(teacher.profileImage()).ifPresent(this::setProfileImage);
        Optional.ofNullable(teacher.password()).ifPresent(this::setEncryptedPassword);
        Optional.ofNullable(teacher.email()).ifPresent(this::setEmail);
        Optional.ofNullable(teacher.contactNumber()).ifPresent(this::setContactNumber);
        Optional.ofNullable(teacher.nickname()).ifPresent(this::setNickname);
        return this;
    }
}
