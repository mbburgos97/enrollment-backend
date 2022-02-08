package com.mbburgos.enrollmentbackendservice.entity;

import com.mbburgos.enrollmentbackendservice.model.Student;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity(name = "student")
@Getter
@Setter
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

    public StudentEntity update(Student student) {
        Optional.ofNullable(student.firstName()).ifPresent(this::setFirstName);
        Optional.ofNullable(student.middleName()).ifPresent(this::setMiddleName);
        Optional.ofNullable(student.lastName()).ifPresent(this::setLastName);
        Optional.ofNullable(student.username()).ifPresent(this::setUsername);
        Optional.ofNullable(student.profileImage()).ifPresent(this::setProfileImage);
        Optional.ofNullable(student.password()).ifPresent(this::setEncryptedPassword);
        Optional.ofNullable(student.email()).ifPresent(this::setEmail);
        Optional.ofNullable(student.contactNumber()).ifPresent(this::setContactNumber);
        Optional.ofNullable(student.nickname()).ifPresent(this::setNickname);
        return this;
    }
}
