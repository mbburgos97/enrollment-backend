package com.mbburgos.enrollmentbackendservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Student(String id, @JsonProperty("first_name") String firstName, @JsonProperty("middle_name") String middleName,
                      @JsonProperty("last_name") String lastName, @JsonProperty("profile_image") String profileImage,
                      String username, String email, @JsonProperty("contact_number") String contactNumber, String nickname,
                      String password) {
}
