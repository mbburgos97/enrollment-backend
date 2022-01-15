package com.mbburgos.enrollmentbackendservice.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record Student(String studentId, String firstName, String middleName, String lastName, String profileImage) {
}
