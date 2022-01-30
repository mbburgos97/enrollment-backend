package com.mbburgos.enrollmentbackendservice.model;

public record Teacher(String id, String firstName, String middleName, String lastName, String profileImage,
                      String username, String email, String contactNumber, String nickname) {
}
